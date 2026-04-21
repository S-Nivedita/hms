package com.example.hms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private String address;
    private String city;
    private String gender;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "reg_date" , nullable = false, updatable = false)
    private LocalDateTime regDate;

    @Column(name = "updation_date")
    private LocalDateTime updationDate;

    @PrePersist
    void onCreate()
    {
        if(this.regDate == null)
        {
            this.regDate = LocalDateTime.now();
        }
        this.updationDate = null;
    }

    @PreUpdate
    void onUpdate()
    {
        this.updationDate = LocalDateTime.now();
    }

}