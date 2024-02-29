package com.willysancyh.trackwave.controller;

import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.entity.FileEntity;
import com.willysancyh.trackwave.model.RangeHeaderModel;
import com.willysancyh.trackwave.service.audio.AudioService;
import com.willysancyh.trackwave.service.file.FileService;
import com.willysancyh.trackwave.service.headers.HeadersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping("/audio")
public class AudioController {

    private final AudioService audioService;
    private final HeadersService headersService;
    private final FileService fileService;

    public AudioController(
            AudioService audioService,
            HeadersService headersService, FileService fileService
    ) {
        this.audioService = audioService;
        this.headersService = headersService;
        this.fileService = fileService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StreamingResponseBody> getAudioStreaming(
            @PathVariable Long audioId,
            @RequestHeader(value = "Range", required = false) String rangeHeader
    ) {
        AudioEntity audioEntity = audioService.getAudioEntity(audioId);
        FileEntity audioFileEntity = audioEntity.getFile();

        RangeHeaderModel rangeHeaderModel = headersService.getRangeHeaderModel(rangeHeader, audioFileEntity);
        HttpHeaders responseHeaders = headersService.getHeadersForFile(rangeHeaderModel, audioFileEntity);
        StreamingResponseBody responseStream = fileService.getFileStream(audioFileEntity, rangeHeaderModel);

        return new ResponseEntity<>(responseStream, responseHeaders, HttpStatus.PARTIAL_CONTENT);
    }
}
