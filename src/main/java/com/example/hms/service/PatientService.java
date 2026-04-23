package com.example.hms.service;

import com.example.hms.dto.PatientRequest;
import com.example.hms.dto.PatientResponse;
import com.example.hms.model.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    public PatientResponse createPatients(PatientRequest patientRequest);
    public PatientResponse getPatientById(Long id);
    public PatientResponse updatePatientById(Long id , Patient patient);
    public List<PatientResponse> getAllpatients();
}
