package com.example.hms.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AppointmentResponse {
    private Long appointmentId;
    private String patientName;
    private String specialization;
    private Long consultancyFees;
    private LocalDate appointmentDate;
    private LocalDateTime creationDate;
    private int status;
}
