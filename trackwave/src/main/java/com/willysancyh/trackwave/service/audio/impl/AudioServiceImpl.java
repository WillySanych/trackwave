package com.willysancyh.trackwave.service.audio.impl;

import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.service.audio.AudioService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Service
public class AudioServiceImpl implements AudioService {
    @Override
    public AudioEntity getAudioEntity(Long audioId) {
        return null;
    }
}
