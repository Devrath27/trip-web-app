package com.trip.backend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
public class GetProfileResponse {
    private String email;
    private String name;
    private long mobileNumber;
    private String profileImage;


}
