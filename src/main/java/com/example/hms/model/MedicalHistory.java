package com.example.hms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name="medical_history")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    private String bloodPressure;
    private String bloodSugar;
    private String weight;
    private String temperature;
    private String medicalPrescription;
    private LocalDateTime creationDate;
    private LocalDateTime updationDate;

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
