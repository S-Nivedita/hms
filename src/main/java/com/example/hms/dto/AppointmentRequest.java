package com.example.hms.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentRequest {
    @NotNull(message = "User ID is required")
    private Long userId;
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
     @NotNull(message = "Consultancy fees are required")
    @Positive(message = "Consultancy fees must be positive")
    private Long consultancyFees;
     @NotNull(message = "Appointment date is required")
    @FutureOrPresent(message = "Appointment date must be today or in the future")
    private LocalDate appointmentDate;
     @NotNull(message = "Appointment time is required")
    private LocalTime appointmentTime;
}
