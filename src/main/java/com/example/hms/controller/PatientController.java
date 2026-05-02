package com.example.hms.controller;

import com.example.hms.dto.*;
import com.example.hms.model.MedicalHistory;
import com.example.hms.model.Patient;
import com.example.hms.service.DoctorService;
import com.example.hms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping()
    public ResponseEntity<PatientResponse> createPatients(@RequestBody PatientRequest patientRequest)
    {
        return ResponseEntity.ok(patientService.createPatients(patientRequest));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<UpdatedDoctorResponse> getDoctorById(@PathVariable Long doctorId)
    {
        return ResponseEntity.ok(doctorService.getDoctorById(doctorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long id)
    {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @GetMapping()
    public ResponseEntity<List<PatientResponse>> getAllPatients()
    {
        return ResponseEntity.ok(patientService.getAllpatients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatientById(@PathVariable Long id , @RequestBody Patient patient)
    {
        return ResponseEntity.ok(patientService.updatePatientById(id , patient));
    }

    @PostMapping("/{patientId}/medical-history")
    public ResponseEntity<MedicalHistoryResponse> createMedicalHistory(@PathVariable Long patientId , @RequestBody MedicalHistoryRequest medicalHistoryRequest)
    {
        return ResponseEntity.ok(patientService.createMedicalHistory(patientId , medicalHistoryRequest));
    }

    @GetMapping("/{patientId}/medical-history")
    public ResponseEntity<MedicalHistoryResponse> getMedicalHistory(@PathVariable Long patientId)
    {
        return ResponseEntity.ok(patientService.getMedicalHistory(patientId));
    }
}
