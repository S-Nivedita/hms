package com.example.hms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UpdateDoctorRequest {
    private Long specializationId;
    private String doctorName;
    private String address;
    private Long doctorFees;
    private Long contactNo;
    private String doctorEmail;
    private String password;
    private String confirmPassword;
}
