package com.example.hms.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class ChangePasswordRequest {

    @NotBlank(message = "Current password is required")
    private String currentPassword;
    @NotBlank(message = "New password is required")
    @Size(min = 10, max = 20, message = "New password must be between 10 and 20 characters")
    private String newPassword;
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;
}
