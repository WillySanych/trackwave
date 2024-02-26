package com.willysancyh.trackwave.service.audio;

import com.willysancyh.trackwave.entity.AudioEntity;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

public interface AudioService {
    public AudioEntity getAudioEntity(Long audioId);
}
