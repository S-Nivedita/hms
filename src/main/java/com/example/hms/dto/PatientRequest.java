package com.example.hms.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PatientRequest {
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
    @NotBlank(message = "Patient name is required")
    private String patientName;
    @NotNull(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be 10 digits")
    private Long patientContactNo;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String patientEmail;
    @NotBlank(message = "Gender is required")
    private String patientGender;
    @NotBlank(message = "Address is required")
    private String patientAddress;
    @Min(value = 0, message = "Age must be positive")
    private int patientAge;
    private String patientMedicalHistory;
}
