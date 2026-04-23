package com.example.hms.service;

import com.example.hms.dto.DashboardResponse;
import com.example.hms.repository.AdminRepository;
import com.example.hms.repository.DoctorRepository;
import com.example.hms.repository.PatientRepository;
import com.example.hms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public DashboardResponse getDashboardDetails()
    {
        DashboardResponse dashRes = new DashboardResponse();
        dashRes.setUserCount(userRepository.count());
        dashRes.setPatientCount(patientRepository.count());
        dashRes.setDoctorCount(doctorRepository.count());
        return dashRes;
    }
}
