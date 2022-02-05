package com.anjalipandey.hackerbills.exception;

/**
 * Record Not Found Exception class
 */
public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(String message) {
        super(message);
    }
}
