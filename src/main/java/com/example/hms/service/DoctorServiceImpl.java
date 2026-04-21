package com.example.hms.service;

import com.example.hms.dto.ChangePasswordRequest;
import com.example.hms.dto.UpdateDoctorRequest;
import com.example.hms.dto.UpdatedDoctorResponse;
import com.example.hms.model.Doctor;
import com.example.hms.model.DoctorSpecialization;
import com.example.hms.repository.DoctorRepository;
import com.example.hms.repository.DoctorSpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorSpecializationRepository doctorSpecializationRepository;
    public UpdatedDoctorResponse updateDoctor(Long id, UpdateDoctorRequest request){
        Doctor doctor=doctorRepository.findById(id).orElseThrow(()->new RuntimeException("Doctor not found"));
        DoctorSpecialization specialization= doctorSpecializationRepository.findById(request.getSpecializationId()).orElseThrow(()->new RuntimeException("Specialization not found"));
        doctor.setSpecialization(specialization);
        doctor.setDoctorName(request.getDoctorName());
        doctor.setAddress(request.getAddress());
        doctor.setDoctorFees(request.getDoctorFees());
        doctor.setContactNo(request.getContactNo());
        doctor.setDoctorEmail(request.getDoctorEmail());
        doctor.setDoctorEmail(request.getDoctorEmail());
        Doctor updated=doctorRepository.save(doctor);
        return mapToResponse(updated);
    }
    private UpdatedDoctorResponse mapToResponse(Doctor doctor){
        UpdatedDoctorResponse dr=new UpdatedDoctorResponse();
        dr.setId(doctor.getId());
        dr.setDoctorName(doctor.getDoctorName());
        dr.setAddress(doctor.getAddress());
        dr.setDoctorFees(doctor.getDoctorFees());
        dr.setContactNo(doctor.getContactNo());
        dr.setDoctorEmail(doctor.getDoctorEmail());
        dr.setDoctorEmail(doctor.getDoctorEmail());
        if(doctor.getSpecialization()!=null){
            dr.setSpecializationName(doctor.getSpecialization().getSpecialization());
        }
        return dr;
    }
    @Override
    public void changePassword(Long doctorId, ChangePasswordRequest request){
       Doctor d=doctorRepository.findById(doctorId).orElseThrow(()->new RuntimeException("Doctor Id not found")) ;
       if(!d.getPassword().equals(request.getCurrentPassword())){
           throw new RuntimeException("Incorrect Password");
       }
       if(!request.getNewPassword().equals(request.getConfirmPassword())){
           throw new RuntimeException("Password mismatch");
       }
       d.setPassword(request.getConfirmPassword());
       d.setUpdationDate(LocalDateTime.now());
       doctorRepository.save(d);
    }
    public List<String> getDoctorNames(){
        List<Doctor> l=doctorRepository.findAll();
        List<String> doctorName=new ArrayList<>();
        l.forEach(i->doctorName.add(i.getDoctorName()));
        return doctorName;
    }
}
