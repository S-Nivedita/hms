package com.example.hms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private LocalDateTime updationDate;
}
