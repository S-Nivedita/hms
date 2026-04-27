package com.example.hms.service;

import com.example.hms.dto.ChangePasswordRequest;
import com.example.hms.dto.ContactQueryRequest;
import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.User;

import java.util.List;

public interface UserService {
    public UserResponse registerUser(UserRequest userRequest);
    public UserResponse loginUser(User user);
    public List<UserResponse> getAllUsers();
    public UserResponse updateUser(Long id,UserRequest userRequests);
    public UserResponse getUserById(Long id);
    public String saveContactQueries(ContactQueryRequest contactQueryRequest);
    public void changePassword(Long userId, ChangePasswordRequest request);
}
