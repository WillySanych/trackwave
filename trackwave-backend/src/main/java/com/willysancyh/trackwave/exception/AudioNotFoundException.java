package com.willysancyh.trackwave.exception;

public class AudioNotFoundException extends RuntimeException {

    public AudioNotFoundException(Long audioId) {
        super("Audio not found with id: " + audioId);
    }
}
