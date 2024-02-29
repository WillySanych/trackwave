package com.willysancyh.trackwave.service.audio.impl;

import com.willysancyh.trackwave.entity.AudioEntity;
import com.willysancyh.trackwave.exception.AudioNotFoundException;
import com.willysancyh.trackwave.repository.AudioRepository;
import com.willysancyh.trackwave.service.audio.AudioService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Service
public class AudioServiceImpl implements AudioService {

    private final AudioRepository audioRepository;

    public AudioServiceImpl(AudioRepository audioRepository) {
        this.audioRepository = audioRepository;
    }

    @Override
    public AudioEntity getAudioEntity(Long audioId) {
        return audioRepository.findById(audioId).orElseThrow(() -> new AudioNotFoundException(audioId));
    }
}
