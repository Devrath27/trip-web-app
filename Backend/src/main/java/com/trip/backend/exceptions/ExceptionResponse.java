package com.trip.backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponse {
    String errorCode;
    String errorMessage;
}
