package com.example.hms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PatientResponse {
    private Long doctorId;
    private String patientName;
    private Long patientContactNo;
    private String patientEmail;
    private String patientGender;
    private String patientAddress;
    private int patientAge;
    private String patientMedicalHistory;
    private LocalDateTime creationDate;
    private LocalDateTime updationDate;
}
