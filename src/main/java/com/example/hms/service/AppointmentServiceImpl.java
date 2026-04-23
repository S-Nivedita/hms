package com.example.hms.service;

import com.example.hms.dto.AppointmentRequest;
import com.example.hms.dto.AppointmentResponse;
import com.example.hms.model.Appointment;
import com.example.hms.model.Doctor;
import com.example.hms.model.DoctorSpecialization;
import com.example.hms.model.User;
import com.example.hms.repository.AppointmentRepository;
import com.example.hms.repository.DoctorRepository;
import com.example.hms.repository.DoctorSpecializationRepository;
import com.example.hms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorSpecializationRepository doctorSpecializationRepository;
    public List<AppointmentResponse> getAppointmentsByUser(Long UserId){
        List<Appointment> appointments=appointmentRepository.findByUser_Id(UserId);
        return appointments.stream().map(this::mapToResponse).toList();
    }
    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId){
        List<Appointment> appointments=appointmentRepository.findByDoctor_Id(doctorId);
        return appointments.stream().map(this::mapToResponse).toList();
    }
    public AppointmentResponse cancelAppointmentByUser(Long appointmentId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(()->new RuntimeException("User Appointment not found"));
        appointment.setUserStatus(0);
        appointmentRepository.save(appointment);
        return mapToResponse(appointment);
    }
    public AppointmentResponse cancelAppointmentByDoctor(Long appointmentId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(()->new RuntimeException("Doctor Appointment not found"));
        appointment.setDoctorStatus(0);;
        appointmentRepository.save(appointment);
        return mapToResponse(appointment);
    }
    public AppointmentResponse bookAppointment(AppointmentRequest appointmentRequest){
        Doctor doctor=doctorRepository.findById(appointmentRequest.getDoctorid()).orElseThrow(()->new RuntimeException("Doctor not found"));
        User user=userRepository.findById(appointmentRequest.getUserid()).orElseThrow(()->new RuntimeException("User not found"));
        DoctorSpecialization doctorSpecialization=doctor.getSpecialization();
        Appointment appointment=new Appointment();
        appointment.setDoctor(doctor);
        appointment.setUser(user);
        appointment.setDoctorSpecialization(doctorSpecialization);
        appointment.setConsultancyFees(doctor.getDoctorFees());
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setAppointmentTime(appointmentRequest.getAppointmentTime());
        appointment.setPostingDate(LocalDateTime.now());
        appointment.setUserStatus(1);
        appointment.setDoctorStatus(1);
        appointmentRepository.save(appointment);
        return mapToResponse(appointment);
    }
    private AppointmentResponse mapToResponse(Appointment appointment){
        AppointmentResponse ar=new AppointmentResponse();
        ar.setAppointmentId(appointment.getId());
        if(appointment.getUser()!=null){
            ar.setPatientName(appointment.getUser().getFullName());
        }
        if(appointment.getDoctorSpecialization()!=null){
            ar.setSpecialization(appointment.getDoctorSpecialization().getSpecialization());
        }
        ar.setConsultancyFees(appointment.getConsultancyFees());
        ar.setAppointmentDate(appointment.getAppointmentDate());
        ar.setCreationDate(appointment.getPostingDate());
        ar.setStatus(appointment.getDoctorStatus());
        return ar;
    }

}