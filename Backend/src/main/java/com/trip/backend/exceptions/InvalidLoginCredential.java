package com.trip.backend.exceptions;

public class InvalidLoginCredential extends Throwable {
    public InvalidLoginCredential(String message) {
        super(message);
    }
}
