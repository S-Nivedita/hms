package com.example.hms.dto;

import lombok.Data;

@Data
public class MedicalHistoryRequest {
    private String bloodPressure;
    private String bloodSugar;
    private String weight;
    private String temperature;
    private String medicalPrescription;
}
