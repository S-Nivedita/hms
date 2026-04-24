package com.example.hms.controller;

import com.example.hms.dto.BookAppointment;
import com.example.hms.dto.ContactQueryRequest;
import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.User;
import com.example.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.registerUser(userRequest));
    }

    @PostMapping("/users/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.loginUser(user));
    }

    @PostMapping("/contact-queries")
    public ResponseEntity<String> saveContactQueries(@RequestBody ContactQueryRequest contactQueryRequest)
    {
        return ResponseEntity.ok(userService.saveContactQueries(contactQueryRequest));
    }
}
