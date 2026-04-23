package com.example.hms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String patientName;
    private long patientContactNo;
    private String patientEmail;
    private String patientGender;
    private String patientAddress;
    private int patientAge;
    private String patientMedicalHistory;
    private LocalDateTime creationDate;
    private LocalDateTime updationDate;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MedicalHistory> medicalHistories;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @PrePersist
    void onCreate()
    {
        if(this.creationDate == null)
        {
            this.creationDate = LocalDateTime.now();
        }
        this.updationDate = null;
    }

    @PreUpdate
    void onUpdate()
    {
        this.updationDate = LocalDateTime.now();
    }
}
