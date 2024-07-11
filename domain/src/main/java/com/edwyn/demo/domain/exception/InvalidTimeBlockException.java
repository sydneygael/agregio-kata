package com.edwyn.demo.domain.exception;

public class InvalidTimeBlockException extends IllegalArgumentException {
    public InvalidTimeBlockException(String message) {
        super(message);
    }
}
