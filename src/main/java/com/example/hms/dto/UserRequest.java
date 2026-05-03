package com.example.hms.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Data
public class UserRequest {
    @NotBlank(message = "Full name cannot be blank")
    private String fullName;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Address cannot be blank")
    private String address;
    @NotBlank(message = "City cannot be blank")
    private String city;
    @NotBlank(message = "Gender cannot be blank")
    private String gender;
}

