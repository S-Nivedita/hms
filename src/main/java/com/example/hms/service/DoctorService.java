package com.example.hms.service;

import com.example.hms.dto.ChangePasswordRequest;
import com.example.hms.dto.UpdatedDoctorRequest;
import com.example.hms.dto.UpdatedDoctorResponse;

import java.util.List;

public interface DoctorService {
    public UpdatedDoctorResponse updateDoctor(Long id, UpdatedDoctorRequest request);
    public void changePassword(Long doctorId, ChangePasswordRequest request);
    public List<UpdatedDoctorResponse> getAllDoctors();
    public UpdatedDoctorResponse getDoctorById(Long id);
    public UpdatedDoctorResponse addDoctor(UpdatedDoctorRequest updateDoctorRequest);
}