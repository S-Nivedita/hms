package com.example.hms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatedDoctorResponse {
    private Long id;
    private String doctorName;
    private String address;
    private Long doctorFees;
    private Long contactNo;
    private String doctorEmail;
    private String specializationName;
}
