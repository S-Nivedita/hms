package com.example.hms.dto;

import lombok.Data;

@Data
public class UpdatedDoctorResponse {
    private Long id;
    private String doctorName;
    private String address;
    private Long doctorFees;
    private Long contactNo;
    private String doctorEmail;
    private String specializationName;
}
