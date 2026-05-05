package com.example.hms.controller;

import com.example.hms.dto.AuthResponse;
import com.example.hms.dto.LoginRequest;
import com.example.hms.dto.UserRequest;
import com.example.hms.dto.UserResponse;
import com.example.hms.model.Admin;
import com.example.hms.model.Doctor;
import com.example.hms.model.User;
import com.example.hms.repository.AdminRepository;
import com.example.hms.repository.DoctorRepository;
import com.example.hms.repository.UserRepository;
import com.example.hms.security.JwtTokenProvider;
import com.example.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AdminRepository adminRepository;

    private final JwtTokenProvider tokenProvider = new JwtTokenProvider();

    @PostMapping("/users/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.registerUser(userRequest));
    }

    @PostMapping("/users/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody LoginRequest req) {
        User user = userRepository.findByEmail(req.getUsername());
        if (user == null || !user.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = tokenProvider.generateToken(user.getEmail(), "USER", user.getId());
        AuthResponse resp = new AuthResponse();
        resp.setToken(token);
        resp.setRole("USER");
        resp.setUserId(user.getId());
        resp.setEmail(user.getEmail());
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/doctors/login")
    public ResponseEntity<AuthResponse> loginDoctor(@RequestBody LoginRequest req) {
        Doctor d = doctorRepository.findByDoctorEmail(req.getUsername());
        if (d == null || !d.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = tokenProvider.generateToken(d.getDoctorEmail(), "DOCTOR", d.getId());
        AuthResponse resp = new AuthResponse();
        resp.setToken(token);
        resp.setRole("DOCTOR");
        resp.setUserId(d.getId());
        resp.setEmail(d.getDoctorEmail());
        return ResponseEntity.ok(resp);
    }
}