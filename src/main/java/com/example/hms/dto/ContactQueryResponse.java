package com.example.hms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactQueryResponse {
    private Long contactQueryId;
    private String fullName;
    private String email;
    private Long contactNo;
    private String message;
    private LocalDateTime postingDate;
}
