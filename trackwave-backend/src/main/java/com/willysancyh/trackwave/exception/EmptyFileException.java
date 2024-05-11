package com.willysancyh.trackwave.exception;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException(String fileName) {
        super("File " + fileName + " is empty");
    }
}
