package com.example.hms.service;

import com.example.hms.dto.MedicalHistoryRequest;
import com.example.hms.dto.MedicalHistoryResponse;
import com.example.hms.dto.PatientRequest;
import com.example.hms.dto.PatientResponse;
import com.example.hms.model.MedicalHistory;
import com.example.hms.model.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    public PatientResponse createPatients(PatientRequest patientRequest);
    public PatientResponse getPatientById(Long id);
    public PatientResponse updatePatientById(Long id , Patient patient);
    public List<PatientResponse> getAllpatients();
    public List<PatientResponse> getPatientsByDoctorId(Long doctorId);
    public MedicalHistoryResponse createMedicalHistory(Long patientId , MedicalHistoryRequest medicalHistoryRequest);
    public List<MedicalHistoryResponse> getMedicalHistoryByPatientID(Long patientId);
}
