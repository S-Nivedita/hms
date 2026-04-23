package com.example.hms.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@Table(name="appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="specialization_id")
    private DoctorSpecialization doctorSpecialization;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private Long consultancyFees;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private LocalDateTime postingDate;
    private int userStatus;
    private int doctorStatus;
    private LocalDate updationDate;
}
