package com.example.hms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminResponse {
    @NotNull(message = "Id cannot be null")
    private Long id;
    @NotBlank(message = "Username cannot be blank")
    private String username;
    private LocalDateTime updationDate;
}
