package com.willysancyh.trackwave.service.audio.impl;

import com.willysancyh.trackwave.dao.AudioEntityDao;
import com.willysancyh.trackwave.dao.AuthorEntityDao;
import com.willysancyh.trackwave.dto.AudioUploadDto;
import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.entity.AuthorEntity;
import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.exception.AudioNotFoundException;
import com.willysancyh.trackwave.model.RangeHeaderModel;
import com.willysancyh.trackwave.service.audio.AudioService;
import com.willysancyh.trackwave.service.author.AuthorService;
import com.willysancyh.trackwave.service.file.FileService;
import com.willysancyh.trackwave.service.headers.HeadersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;

@Service
public class AudioServiceImpl implements AudioService {

    private final HeadersService headersService;
    private final FileService fileService;
    private final AudioEntityDao audioEntityDao;
    private final AuthorService authorService;

    public AudioServiceImpl(
            HeadersService headersService,
            FileService fileService,
            AudioEntityDao audioEntityDao,
            AuthorService authorService
    ) {
        this.headersService = headersService;
        this.fileService = fileService;
        this.audioEntityDao = audioEntityDao;
        this.authorService = authorService;
    }

    @Override
    public ResponseEntity<StreamingResponseBody> getAudioStreamingResponse(Long audioId, String rangeHeader) {
        AudioEntity audioEntity = audioEntityDao.findById(audioId).orElseThrow(() -> new AudioNotFoundException(audioId));
        FileEntity audioFileEntity = audioEntity.getFileEntity();

        RangeHeaderModel rangeHeaderModel = headersService.getRangeHeaderModel(rangeHeader, audioFileEntity);
        HttpHeaders responseHeaders = headersService.getHeadersForFile(rangeHeaderModel, audioFileEntity);
        StreamingResponseBody responseStream = fileService.getFileStream(audioFileEntity, rangeHeaderModel);

        return new ResponseEntity<>(responseStream, responseHeaders, HttpStatus.PARTIAL_CONTENT);
    }

    @Override
    @Transactional
    public AudioEntity saveAudioEntity(MultipartFile audioFile, AudioUploadDto audioUploadDto) {
        FileEntity fileEntity = fileService.saveFileToStorage(audioFile);
        AuthorEntity authorEntity = authorService.saveAuthorEntity(audioUploadDto);

        AudioEntity audioEntity = new AudioEntity();
        audioEntity.setFileEntity(fileEntity);
        audioEntity.setAuthorEntity(authorEntity);
        audioEntity.setName(audioUploadDto.getName());
        return audioEntityDao.saveAudioEntity(audioEntity);
    }

    @Override
    public List<AudioEntity> getAudioEntityList(String searchText) {
        return audioEntityDao.findBySearchText(searchText);
    }
}
