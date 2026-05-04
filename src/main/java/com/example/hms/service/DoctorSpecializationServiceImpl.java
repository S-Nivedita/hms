package com.example.hms.service;

import com.example.hms.dto.DoctorSpecializationRequest;
import com.example.hms.dto.DoctorSpecializationResponse;
import com.example.hms.model.DoctorSpecialization;
import com.example.hms.repository.DoctorSpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class DoctorSpecializationServiceImpl implements DoctorSpecializationService{
    @Autowired
    private DoctorSpecializationRepository doctorSpecializationRepository;
    public List<DoctorSpecializationResponse> getAllSpecialization(){
        List<DoctorSpecialization> l=doctorSpecializationRepository.findAll();
        return  l.stream().map(this::mapToResponse).toList();

    }
    public DoctorSpecializationResponse addDoctorsSpecialization(DoctorSpecializationRequest doctorSpecializationRequest){
        DoctorSpecialization ds=new DoctorSpecialization();
        ds.setSpecialization(doctorSpecializationRequest.getSpecialization());
        ds.setCreationDate(now());
        ds.setUpdationDate(now());
        doctorSpecializationRepository.save(ds);
        return mapToResponse(ds);
    }
    public String delete(Long id){
        DoctorSpecialization ds=doctorSpecializationRepository.findById(id).orElseThrow(()->new RuntimeException("Doctor Specialization not found"));
        doctorSpecializationRepository.delete(ds);
        return "Doctor Specialization Deleted successfully";
    }
    public DoctorSpecializationResponse updateDoctorSpecialization(DoctorSpecializationRequest doctorSpecializationRequest,Long id){
        DoctorSpecialization ds=doctorSpecializationRepository.findById(id).orElseThrow(()->new RuntimeException("Doctor Specialization not found"));
        ds.setSpecialization(doctorSpecializationRequest.getSpecialization());
        ds.setUpdationDate(now());
        doctorSpecializationRepository.save(ds);
        return mapToResponse(ds);
    }
    public DoctorSpecializationResponse mapToResponse(DoctorSpecialization ds){
        DoctorSpecializationResponse dsr=new DoctorSpecializationResponse();
        dsr.setSpecialization(ds.getSpecialization());
        dsr.setCreationDate(ds.getCreationDate());
        dsr.setUpdationDate(ds.getUpdationDate());
        dsr.setId(ds.getId());
        return dsr;
    }
}
