package com.example.hms.service;


import com.example.hms.dto.ChangePasswordRequest;
import com.example.hms.dto.UpdateDoctorRequest;
import com.example.hms.dto.DoctorResponse;

public interface DoctorService {

    DoctorResponse updateDoctor(Long id, UpdateDoctorRequest request);
    void changePassword(Long doctorId, ChangePasswordRequest request);
}