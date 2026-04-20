package com.example.hms.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Entity
@Data
@Table(name = "doctor_specialization")
public class  DoctorSpecialization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String specialization;
    private LocalDateTime creationDate;
    private LocalDateTime updationDate;
}

