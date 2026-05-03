package com.example.hms.dto;

import com.example.hms.model.Doctor;
import com.example.hms.model.DoctorSpecialization;
import com.example.hms.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
public class AppointmentResponse {
    @NotNull(message = "Appointment ID cannot be null")
    private Long appointmentId;
    @NotBlank(message = "Patient name cannot be blank")
    private String patientName;
    @NotBlank(message = "Specialization cannot be blank")
    private String specialization;
    @NotNull(message = "Consultancy fees cannot be null")
    @Positive(message = "Consultancy fees must be positive")
    private Long consultancyFees;
    @NotNull(message = "Appointment date cannot be null")
    @FutureOrPresent(message = "Appointment date must be today or in the future")
    private LocalDate appointmentDate;
    @NotNull(message = "Creation date cannot be null")
    private LocalDateTime creationDate;
    @NotNull(message = "Status cannot be null")
    private int status;
}
