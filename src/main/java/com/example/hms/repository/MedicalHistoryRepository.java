package com.example.hms.repository;

import com.example.hms.model.MedicalHistory;
import com.example.hms.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory , Long> {
    public MedicalHistory findByPatient(Patient patient);
}
