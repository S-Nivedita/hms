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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public AppointmentResponse bookAppointment(AppointmentRequest appointmentRequest)
    {
        Doctor doctor=doctorRepository.findById(appointmentRequest.getDoctorId()).orElseThrow(()->new RuntimeException("Doctor not found"));
        User user=userRepository.findById(appointmentRequest.getUserId()).orElseThrow(()->new RuntimeException("User not found"));
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

    public List<AppointmentResponse> getAllAppointments()
    {
        List<AppointmentResponse> appointmentResponses = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.findAll();
        for(Appointment appointment: appointments)
        {
            appointmentResponses.add(mapToResponse(appointment));
        }
        return appointmentResponses;
    }

    public List<AppointmentResponse> getAppointmentsByUser(Long UserId)
    {
        List<Appointment> appointments=appointmentRepository.findByUser_Id(UserId);
        return appointments.stream().map(this::mapToResponse).toList();
    }

    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId)
    {
        List<Appointment> appointments=appointmentRepository.findByDoctor_Id(doctorId);
        return appointments.stream().map(this::mapToResponse).toList();
    }

    public String cancelAppointmentByUser(Long appointmentId)
    {
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(()->new RuntimeException("User Appointment not found"));
        appointment.setUserStatus(0);
        appointment.setAppointmentDate(LocalDate.now());
        appointmentRepository.save(appointment);
        return "Cancel by You";
    }

    public String cancelAppointmentByDoctor(Long appointmentId)
    {
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(()->new RuntimeException("Doctor Appointment not found"));
        appointment.setDoctorStatus(0);
        appointment.setUpdationDate(LocalDate.now());
        appointmentRepository.save(appointment);
        return "Cancel by Doctor";
    }

    private AppointmentResponse mapToResponse(Appointment appointment)
    {
        AppointmentResponse ar=new AppointmentResponse();
        ar.setAppointmentId(appointment.getId());
        ar.setDoctorName(appointment.getDoctor().getDoctorName() != null?appointment.getDoctor().getDoctorName():null);
        if(appointment.getUser()!=null){
            ar.setPatientName(appointment.getUser().getFullName());
        }
        if(appointment.getDoctorSpecialization()!=null){
            ar.setSpecialization(appointment.getDoctorSpecialization().getSpecialization());
        }
        ar.setConsultancyFees(appointment.getConsultancyFees());
        ar.setAppointmentDate(appointment.getAppointmentDate());
        ar.setAppointmentTime(appointment.getAppointmentTime());
        ar.setCreationDate(appointment.getPostingDate());
        if(appointment.getDoctorStatus() == 0)
        {
            ar.setCurrentStatus("Cancel by Doctor");
        }
        else if(appointment.getUserStatus() == 0)
        {
            ar.setCurrentStatus("Cancel by User");
        }
        else
        {
            ar.setCurrentStatus("Active");
        }
        ar.setStatus(appointment.getDoctorStatus());
        return ar;
    }
}
