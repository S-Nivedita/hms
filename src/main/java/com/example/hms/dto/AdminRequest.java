package com.example.hms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminRequest {
    private Long id;
    private String username;
    private String password;
    private LocalDateTime updationDate;
}
