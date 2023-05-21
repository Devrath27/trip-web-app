package com.trip.backend.controller.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class UserLoginRequest {
    @NotBlank
    @Email
    String email;

    @NotBlank
    String password;
}
