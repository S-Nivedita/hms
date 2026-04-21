package com.example.hms.service;

import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
    UserResponse loginUser(User user);
     List<UserResponse> getAllUsers();
     UserResponse updateUser(Long id,UserRequest userRequests);
     UserResponse getUserById(Long id);
}
