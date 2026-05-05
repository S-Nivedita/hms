package com.example.hms.service;
import com.example.hms.dto.DoctorSpecializationRequest;
import com.example.hms.dto.DoctorSpecializationResponse;

import java.util.List;
public interface DoctorSpecializationService {
    List<DoctorSpecializationResponse> getAllSpecialization();
    DoctorSpecializationResponse addDoctorsSpecialization(DoctorSpecializationRequest doctorSpecializationRequest);
    DoctorSpecializationResponse updateDoctorSpecialization(DoctorSpecializationRequest doctorSpecializationRequest,Long id);
    String delete(Long id);
}