package com.example.hms.controller;

import com.example.hms.service.DoctorSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/doctorSpecialization")
@CrossOrigin
public class DoctorSpecializationController {
    @Autowired
    private DoctorSpecializationService doctorSpecializationService;
    @GetMapping()
    public ResponseEntity<List<String>> getAllSpecialization(){
        List<String> l= doctorSpecializationService.getAllSpecialization();
        return ResponseEntity.ok(l);
    }
}
