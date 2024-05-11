package com.willysancyh.trackwave.exception;

public class SaveFileToStorageException extends RuntimeException {
    public SaveFileToStorageException(String fileName) {
        super("Unable to save file " + fileName + "to storage");
    }
}
