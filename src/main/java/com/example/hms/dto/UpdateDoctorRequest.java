package com.example.hms.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UpdateDoctorRequest {
    @NotNull(message = "Specialization ID is required")
    private Long specializationId;
    @NotBlank(message = "Doctor name is required")
    private String doctorName;
    @NotBlank(message = "Address is required")
    private String address;
    @NotNull(message = "Doctor fees are required")
    @Positive(message = "Doctor fees must be positive")
    private Long doctorFees;
    @NotNull(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be a valid 10-digit number")
    private Long contactNo;
    @NotBlank(message = "email is required")
    @Email(message = "Invalid email format")
    private String doctorEmail;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;
}
