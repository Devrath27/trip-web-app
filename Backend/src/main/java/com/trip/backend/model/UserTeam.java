package com.trip.backend.model;

import javax.persistence.*;

@Entity
@Table
public class UserTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    private int userId;
    private int teamId;
}
