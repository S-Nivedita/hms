package com.example.hms.service;

import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.User;

public interface UserService {

    UserResponse registerUser(UserRequest userRequest);
    UserResponse loginUser(User user);
}
