package com.example.hms.controller;

import com.example.hms.dto.BookAppointment;
import com.example.hms.service.UserService;
import com.example.hms.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    private UserService userService;
    @PostMapping("/appointment/{id}")
    public ResponseEntity<String> bookAppointment(BookAppointment request){
        return ResponseEntity.ok("Successfully Booked");
    }

}
