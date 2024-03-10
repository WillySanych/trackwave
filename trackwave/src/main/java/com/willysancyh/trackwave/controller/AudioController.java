package com.willysancyh.trackwave.controller;

import com.willysancyh.trackwave.dto.AudioDto;
import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.service.audio.AudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping("/audio")
public class AudioController {

    private final AudioService audioService;

    public AudioController(
            AudioService audioService
    ) {
        this.audioService = audioService;
    }

    @PostMapping("/upload")
    public ResponseEntity<AudioDto> uploadAudio(
            @RequestPart("file") MultipartFile audioFile
    ) {
        AudioEntity audioEntity = audioService.saveAudioEntity(audioFile);
        AudioDto audioDto = AudioDto.createFromEntity(audioEntity);
        return new ResponseEntity<>(audioDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StreamingResponseBody> getAudioStreaming(
            @PathVariable Long audioId,
            @RequestHeader(value = "Range", required = false) String rangeHeader
    ) {
        return audioService.getAudioStreamingResponse(audioId, rangeHeader);
    }
}
