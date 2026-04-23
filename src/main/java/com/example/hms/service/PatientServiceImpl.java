package com.example.hms.service;

import com.example.hms.dto.PatientRequest;
import com.example.hms.dto.PatientResponse;
import com.example.hms.model.Doctor;
import com.example.hms.model.Patient;
import com.example.hms.repository.DoctorRepository;
import com.example.hms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public PatientServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository)
    {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public PatientResponse createPatients(PatientRequest patientRequest)
    {
        Patient patient = new Patient();
        Doctor doctor = doctorRepository.findById(patientRequest.getDoctorId()).get();
        patient.setDoctor(doctor);
        patient.setPatientName(patientRequest.getPatientName());
        patient.setPatientContactNo(patientRequest.getPatientContactNo());
        patient.setPatientEmail(patientRequest.getPatientEmail());
        patient.setPatientGender(patientRequest.getPatientGender());
        patient.setPatientAddress(patientRequest.getPatientAddress());
        patient.setPatientAge(patientRequest.getPatientAge());
        patient.setPatientMedicalHistory(patientRequest.getPatientMedicalHistory());
        patient.setCreationDate(LocalDateTime.now());
        Patient res = patientRepository.save(patient);
        return mapToResponse(res);
    }

    public PatientResponse getPatientById(Long id)
    {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent())
        {
            return mapToResponse(patient.get());
        }
        else
        {
            throw new RuntimeException("Patient Not Found");
        }
    }

    public List<PatientResponse> getAllpatients()
    {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponse> patientsList = new ArrayList<>();
        for(Patient patient : patients)
        {
            patientsList.add(mapToResponse(patient));
        }
        return patientsList;
    }

    public PatientResponse updatePatientById(Long id , Patient patient)
    {
        Optional<Patient> currentPatient = patientRepository.findById(id);
        if(currentPatient.isPresent())
        {
            Patient newPatient = currentPatient.get();
            newPatient.setPatientName(patient.getPatientName());
            newPatient.setPatientContactNo(patient.getPatientContactNo());
            newPatient.setPatientEmail(patient.getPatientEmail());
            newPatient.setPatientGender(patient.getPatientGender());
            newPatient.setPatientAddress(patient.getPatientAddress());
            newPatient.setPatientAge(patient.getPatientAge());
            newPatient.setPatientMedicalHistory(patient.getPatientMedicalHistory());
            newPatient.setUpdationDate(LocalDateTime.now());
            Patient res = patientRepository.save(newPatient);
            return mapToResponse(newPatient);
        }
        throw new RuntimeException("Patient Not Found");
    }

    public PatientResponse mapToResponse(Patient patient)
    {
        PatientResponse response = new PatientResponse();
        response.setDoctorId(patient.getDoctor().getId());
        response.setPatientName(patient.getPatientName());
        response.setPatientContactNo(patient.getPatientContactNo());
        response.setPatientEmail(patient.getPatientEmail());
        response.setPatientGender(patient.getPatientGender());
        response.setPatientAddress(patient.getPatientAddress());
        response.setPatientAge(patient.getPatientAge());
        response.setPatientMedicalHistory(patient.getPatientMedicalHistory());
        response.setCreationDate(patient.getCreationDate());
        response.setUpdationDate(patient.getUpdationDate());
        return response;
    }
}
