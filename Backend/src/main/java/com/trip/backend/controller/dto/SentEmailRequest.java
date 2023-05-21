package com.trip.backend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class SentEmailRequest {
    @NotBlank
    String otp;
}
