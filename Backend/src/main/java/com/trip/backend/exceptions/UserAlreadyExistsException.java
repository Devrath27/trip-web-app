package com.trip.backend.exceptions;

public class UserAlreadyExistsException extends Exception {


    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
