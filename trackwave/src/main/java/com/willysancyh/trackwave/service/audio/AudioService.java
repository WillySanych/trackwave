package com.willysancyh.trackwave.service.audio;

import com.willysancyh.trackwave.entity.AudioEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

public interface AudioService {
    public ResponseEntity<StreamingResponseBody> getAudioStreamingResponse(Long audioId, String rangeHeader);
    public AudioEntity saveAudioEntity(MultipartFile audioFile);
}
