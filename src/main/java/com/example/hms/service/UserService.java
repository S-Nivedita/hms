package com.example.hms.service;

import com.example.hms.dto.ContactQueryRequest;
import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.User;

public interface UserService {

    public UserResponse registerUser(UserRequest userRequest);
    public UserResponse loginUser(User user);
    public String saveContactQueries(ContactQueryRequest contactQueryRequest);
}
