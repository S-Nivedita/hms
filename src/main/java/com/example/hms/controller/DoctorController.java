package com.example.hms.controller;

import com.example.hms.dto.ChangePasswordRequest;
import com.example.hms.dto.UpdatedDoctorResponse;
import com.example.hms.dto.UpdatedDoctorRequest;
import com.example.hms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    DoctorController(DoctorService doctorService)
    {
        this.doctorService=doctorService;
    }

    @PostMapping()
    public ResponseEntity<UpdatedDoctorResponse> postDoctor(@RequestBody UpdatedDoctorRequest updateDoctorRequest)
    {
        return ResponseEntity.ok(doctorService.addDoctor(updateDoctorRequest));
    }

    @GetMapping()
    public ResponseEntity<List<UpdatedDoctorResponse>> getAllDoctor()
    {
        List<UpdatedDoctorResponse> l= doctorService.getAllDoctors();
        return ResponseEntity.ok(l);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdatedDoctorResponse> getDoctorById(@PathVariable Long id)
    {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<UpdatedDoctorResponse> updateDoctor(@PathVariable Long id, @RequestBody UpdatedDoctorRequest request)
    {
        return ResponseEntity.ok(doctorService.updateDoctor(id,request));
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<String> changePassword(@PathVariable Long id, @RequestBody ChangePasswordRequest request)
    {
        doctorService.changePassword(id,request);
        return ResponseEntity.ok("Password Changed successfully");
    }
}