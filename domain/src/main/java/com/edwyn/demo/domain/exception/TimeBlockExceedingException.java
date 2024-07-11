package com.edwyn.demo.domain.exception;

public class TimeBlockExceedingException extends IllegalArgumentException {
    public TimeBlockExceedingException(String message) {
        super(message);
    }
}
