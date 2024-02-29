package com.willysancyh.trackwave.exception.handler;

import com.willysancyh.trackwave.exception.AudioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TrackwaveExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AudioNotFoundException.class)
    public ResponseEntity<String> handleAudioNotFoundException(AudioNotFoundException ex) {
        return buildResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<String> buildResponseEntity(String description, HttpStatus httpStatus) {
        return new ResponseEntity<String>(description, httpStatus);
    }
}
