package com.willysancyh.trackwave.service.file.impl;

import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.model.RangeHeaderModel;
import com.willysancyh.trackwave.service.file.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.RandomAccessFile;

@Service
public class FileServiceImpl implements FileService {
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
}
