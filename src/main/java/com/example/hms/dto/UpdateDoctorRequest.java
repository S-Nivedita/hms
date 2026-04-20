package com.example.hms.dto;

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
}
