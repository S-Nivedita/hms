package com.example.hms.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
public class PatientResponse {
    @NotNull(message = "Doctor ID cannot be null")
    private Long doctorId;
    @NotBlank(message = "Patient name cannot be blank")
    private String patientName;
    @NotNull(message = "Patient contact number cannot be null")
    private Long patientContactNo;
    @NotBlank(message = "Patient email cannot be blank")
    @Email(message = "Invalid email format")
    private String patientEmail;
    @NotBlank(message = "Patient gender cannot be blank")
    private String patientGender;
    @NotBlank(message = "Patient address cannot be blank")
    private String patientAddress;
    @NotBlank(message = "Patient age cannot be blank")
    @Positive(message = "Patient age must be positive")
    private int patientAge;
    private String patientMedicalHistory;
    @NotNull(message = "Creation date cannot be null")
    private LocalDateTime creationDate;
    private LocalDateTime updationDate;
}
