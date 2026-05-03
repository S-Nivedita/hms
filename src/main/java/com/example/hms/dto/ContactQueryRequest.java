package com.example.hms.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@Data
public class ContactQueryRequest {
    @NotBlank(message = "Full name cannot be blank")
    private String fullName;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
    @NotNull(message = "Contact number cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be a valid 10-digit number")
    private Long contactNo;
    private String message;
}
