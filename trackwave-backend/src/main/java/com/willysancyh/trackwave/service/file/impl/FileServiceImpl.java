package com.willysancyh.trackwave.service.file.impl;

import com.willysancyh.trackwave.dao.FileEntityDao;
import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.exception.EmptyFileException;
import com.willysancyh.trackwave.exception.SaveFileToStorageException;
import com.willysancyh.trackwave.model.RangeHeaderModel;
import com.willysancyh.trackwave.properties.StorageProperties;
import com.willysancyh.trackwave.service.file.FileService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private final StorageProperties storageProperties;
    private final FileEntityDao fileEntityDao;

    public FileServiceImpl(
            StorageProperties storageProperties,
            FileEntityDao fileEntityDao
    ) {
        this.storageProperties = storageProperties;
        this.fileEntityDao = fileEntityDao;
    }

    @PostConstruct
    public void init() {
        String storageLocation = storageProperties.getLocation();
        File storageDir = new File(storageLocation);
        if (!storageDir.exists()) {
            storageDir.mkdir();
        }
    }

    @Override
    public StreamingResponseBody getFileStream(FileEntity fileEntity, RangeHeaderModel rangeHeaderModel) {
        byte[] buffer = new byte[1024];

        final long rangeFrom = rangeHeaderModel.getRangeFrom();
        final long rangeTo = rangeHeaderModel.getRangeTo();

        File file = new File(fileEntity.getPath());

        StreamingResponseBody responseStream = outputStream -> {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try (randomAccessFile) {
                long pos = rangeFrom;
                randomAccessFile.seek(pos);
                while (pos < rangeTo) {
                    randomAccessFile.read(buffer);
                    outputStream.write(buffer);
                    pos += buffer.length;
                }
                randomAccessFile.close();
                outputStream.flush();
            }
        };

        return responseStream;
    }

    @Override
    public FileEntity saveFileToStorage(MultipartFile multipartFile) {
        FileEntity fileEntity = new FileEntity();
        if (!multipartFile.isEmpty()) {
            try {
                byte[] bytes = multipartFile.getBytes();

                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + multipartFile.getOriginalFilename();
                File file = new File(storageProperties.getLocation() + "/" + resultFilename);
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
                outputStream.write(bytes);
                outputStream.close();

                fileEntity.setPath(resultFilename);
            } catch (IOException e) {
                throw new SaveFileToStorageException(multipartFile.getOriginalFilename());
            }
        } else {
            throw new EmptyFileException(multipartFile.getOriginalFilename());
        }

        return saveFileEntity(fileEntity);
    }

    private FileEntity saveFileEntity(FileEntity fileEntity) {
        return fileEntityDao.saveFileEntity(fileEntity);
    }
}
