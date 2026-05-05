package com.example.hms.repository;

import com.example.hms.model.Doctor;
import com.example.hms.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    public Doctor findByDoctorEmail(String email);
}