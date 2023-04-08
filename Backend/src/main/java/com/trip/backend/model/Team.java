package com.trip.backend.model;

import com.trip.backend.controller.dto.Contribution;
import com.trip.backend.controller.dto.Message;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    private String type;
    @Column(columnDefinition = "jsonb")
    @Type(type="jsonb")
    private ArrayList<Message> message;

    @Column(columnDefinition = "jsonb")
    @Type(type="jsonb")
    private ArrayList<String> media;

    @Column(columnDefinition = "jsonb")
    @Type(type="jsonb")
    private ArrayList<Contribution> contributions;



}
