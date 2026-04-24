package com.example.hms.service;

import com.example.hms.model.DoctorSpecialization;
import com.example.hms.repository.DoctorSpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorSpecializationServiceImpl implements DoctorSpecializationService{
    @Autowired
    private DoctorSpecializationRepository doctorSpecializationRepository;
    
    public List<String> getAllSpecialization()
    {
        List<DoctorSpecialization>l=doctorSpecializationRepository.findAll();
        List<String> list=new ArrayList<>();
        l.forEach(i->list.add(i.getSpecialization()));
        return list;
    }
}
