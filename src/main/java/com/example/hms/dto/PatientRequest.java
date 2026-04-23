package com.example.hms.dto;

import lombok.Data;

@Data
public class PatientRequest {
    private Long doctorId;
    private String patientName;
    private Long patientContactNo;
    private String patientEmail;
    private String patientGender;
    private String patientAddress;
    private int patientAge;
    private String patientMedicalHistory;
}

