package com.trip.backend.exceptions;

public class InvalidLoginCredential extends Exception {
    public InvalidLoginCredential(String message) {
        super(message);
    }
}
