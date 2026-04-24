package com.example.hms.dto;

import lombok.Data;

@Data
public class DashboardResponse {

    private Long userCount;
    private Long patientCount;
    private Long doctorCount;
}
