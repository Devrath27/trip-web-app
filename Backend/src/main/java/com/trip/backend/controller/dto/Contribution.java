package com.trip.backend.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
@Setter
public class Contribution implements Serializable {
    String userWhoPay;
    String userForWhomPaid;
    long money;
    LocalDateTime time;
    String comment;

}
