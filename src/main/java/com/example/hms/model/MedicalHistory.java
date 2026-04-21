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
}
