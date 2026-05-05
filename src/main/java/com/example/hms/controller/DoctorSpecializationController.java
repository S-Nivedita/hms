package com.example.hms.controller;

import com.example.hms.dto.DoctorSpecializationRequest;
import com.example.hms.dto.DoctorSpecializationResponse;
import com.example.hms.service.DoctorSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/doctor-specializations")
@CrossOrigin
public class DoctorSpecializationController {
    @Autowired
    private DoctorSpecializationService doctorSpecializationService;

    @GetMapping()
    public ResponseEntity<List<DoctorSpecializationResponse>> getAllSpecialization(){
        List<DoctorSpecializationResponse> l= doctorSpecializationService.getAllSpecialization();
        return ResponseEntity.ok(l);
    }
    @PostMapping()
    public ResponseEntity<DoctorSpecializationResponse> addDoctorSpecialization(@RequestBody DoctorSpecializationRequest doctorSpecializationRequest){
        return ResponseEntity.ok(doctorSpecializationService.addDoctorsSpecialization(doctorSpecializationRequest));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<DoctorSpecializationResponse> editDoctorSpecialization(@RequestBody DoctorSpecializationRequest doctorSpecializationRequest,@PathVariable Long id){
        return ResponseEntity.ok(doctorSpecializationService.updateDoctorSpecialization(doctorSpecializationRequest,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorSpecialization(@PathVariable Long id){
        String str=doctorSpecializationService.delete(id);
        return ResponseEntity.ok(str);
    }
}