package com.example.hms.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String role;
    private Long userId;
    private String email;
}