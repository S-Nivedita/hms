package com.example.hms.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentRequest {
    private Long userId;
    private Long doctorId;
    private Long consultancyFees;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
}
