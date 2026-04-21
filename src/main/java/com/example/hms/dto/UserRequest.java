package com.example.hms.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String gender;
}
