package com.example.hms.controller;

import com.example.hms.dto.AppointmentRequest;
import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.User;
import com.example.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.registerUser(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.loginUser(user));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUser(){
        List<UserResponse> l=userService.getAllUsers();
        return ResponseEntity.ok(l);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,@RequestBody UserRequest userRequest){
        UserResponse  userResponse=userService.updateUser(id,userRequest);
        return ResponseEntity.ok(userResponse);

    }

}