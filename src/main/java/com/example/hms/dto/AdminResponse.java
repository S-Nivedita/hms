package com.example.hms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminResponse {
    private Long id;
    private String username;
    private LocalDateTime updationDate;
}
