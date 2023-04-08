package com.trip.backend.exceptions;

public class ForbiddenRequestException extends Exception {
    public ForbiddenRequestException(String message) {
        super(message);
    }
}
