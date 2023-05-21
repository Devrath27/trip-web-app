package com.trip.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    private String email;
    private String password;
    private String name;
    @Column(name="mobilenumber")
    private long mobileNumber;
    @Column(name="profileimage")
    private String profileImage;


    public User(String email, String password, String name, long mobileNumber, String profileImage) {
        this.email=email;
        this.password=password;
        this.name=name;
        this.mobileNumber=mobileNumber;
        this.profileImage=profileImage;
    }
}
