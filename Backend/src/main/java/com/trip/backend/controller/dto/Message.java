package com.trip.backend.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class Message {
    String user;
    LocalDateTime time;
    String message;
}
