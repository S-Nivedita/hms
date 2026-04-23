package com.example.hms.service;


import com.example.hms.dto.ChangePasswordRequest;
import com.example.hms.dto.UpdateDoctorRequest;
import com.example.hms.dto.UpdatedDoctorResponse;

import java.util.List;

public interface DoctorService {

    UpdatedDoctorResponse updateDoctor(Long id, UpdateDoctorRequest request);

    void changePassword(Long doctorId, ChangePasswordRequest request);

    List<UpdatedDoctorResponse> getAllDoctors();
    UpdatedDoctorResponse getDoctorById(Long id);
    UpdatedDoctorResponse addDoctor(UpdateDoctorRequest updateDoctorRequest);
}