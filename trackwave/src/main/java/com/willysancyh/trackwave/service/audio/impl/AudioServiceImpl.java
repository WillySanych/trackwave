package com.willysancyh.trackwave.service.audio.impl;

import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.exception.AudioNotFoundException;
import com.willysancyh.trackwave.model.RangeHeaderModel;
import com.willysancyh.trackwave.repository.AudioRepository;
import com.willysancyh.trackwave.service.audio.AudioService;
import com.willysancyh.trackwave.service.file.FileService;
import com.willysancyh.trackwave.service.headers.HeadersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Service
public class AudioServiceImpl implements AudioService {

    private final HeadersService headersService;
    private final FileService fileService;
    private final AudioRepository audioRepository;

    public AudioServiceImpl(
            HeadersService headersService,
            FileService fileService,
            AudioRepository audioRepository
    ) {
        this.headersService = headersService;
        this.fileService = fileService;
        this.audioRepository = audioRepository;
    }

    @Override
    public ResponseEntity<StreamingResponseBody> getAudioStreamingResponse(Long audioId, String rangeHeader) {
        AudioEntity audioEntity = audioRepository.findById(audioId).orElseThrow(() -> new AudioNotFoundException(audioId));
        FileEntity audioFileEntity = audioEntity.getFile();

        RangeHeaderModel rangeHeaderModel = headersService.getRangeHeaderModel(rangeHeader, audioFileEntity);
        HttpHeaders responseHeaders = headersService.getHeadersForFile(rangeHeaderModel, audioFileEntity);
        StreamingResponseBody responseStream = fileService.getFileStream(audioFileEntity, rangeHeaderModel);

        return new ResponseEntity<>(responseStream, responseHeaders, HttpStatus.PARTIAL_CONTENT);
    }

    @Override
    public AudioEntity saveAudioEntity(MultipartFile audioFile) {
        FileEntity fileEntity = fileService.saveFileToStorage(audioFile);
        AudioEntity audioEntity = new AudioEntity();
        audioEntity.setFile(fileEntity);
        return audioRepository.save(audioEntity);
    }
}
