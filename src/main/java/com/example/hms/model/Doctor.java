package com.example.hms.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="specialization_id")
    private DoctorSpecialization specialization;
    private String doctorName;
    private String address;
    private Long doctorFees;
    private Long contactNo;
    private String doctorEmail;
    private String password;
    private LocalDateTime creationDate;
    private LocalDateTime updationDate;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

}
