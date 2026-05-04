package com.example.hms.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DoctorSpecializationRequest {
    private Long id;
    private String specialization;
    private LocalDateTime creationDate;
    private LocalDateTime updationDate;
}
