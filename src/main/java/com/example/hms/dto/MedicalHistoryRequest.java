package com.example.hms.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicalHistoryRequest {
    @NotBlank(message = "Blood pressure cannot be blank")
    private String bloodPressure;
    @NotBlank(message = "Blood sugar cannot be blank")
    private String bloodSugar;
    @NotBlank(message = "Weight cannot be blank")
    private String weight;
    @NotBlank(message = "Temperature cannot be blank")
    private String temperature;
    @NotBlank(message = "Medical prescription cannot be blank")
    private String medicalPrescription;
}
