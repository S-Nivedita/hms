package com.example.hms.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Long userId;
    private String fullName;
    private String email;
    private String address;
    private String city;
    private String gender;
    private LocalDateTime regDate;
    private LocalDateTime updationDate;
}
