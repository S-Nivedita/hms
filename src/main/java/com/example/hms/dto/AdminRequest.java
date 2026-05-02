package com.example.hms.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class AdminRequest {
    @NotNull(message="Id is required")
    private Long id;
    @NotNull(message="Name field is required")
    private String username;
    @NotNull(message="password is required")
    private String password;
    private LocalDateTime updationDate;
}
