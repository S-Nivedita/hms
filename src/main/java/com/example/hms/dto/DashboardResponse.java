package com.example.hms.dto;

import lombok.Data;

@Data
public class DashboardResponse {
    private Long userCount;
    private Long doctorCount;
    private Long appointmentCount;
    private Long patientCount;
    private Long queriesCount;
}
