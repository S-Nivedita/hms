package com.example.hms.dto;

import lombok.Data;

@Data
public class UpdatedDoctorRequest {
    private Long specializationId;
    private String doctorName;
    private String address;
    private Long doctorFees;
    private Long contactNo;
    private String doctorEmail;
    private String password;
    private String confirmPassword;
}
