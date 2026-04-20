package com.example.hms.repository;

import com.example.hms.model.Appointment;
import com.example.hms.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByDoctor_Id(Long doctorId);
}
