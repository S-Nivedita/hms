package com.example.hms.service;

import com.example.hms.dto.AppointmentResponse;
import com.example.hms.model.Appointment;
import com.example.hms.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId){
        List<Appointment> appointments=appointmentRepository.findByDoctor_Id(doctorId);
        return appointments.stream().map(this::mapToResponse).toList();
    }
    public void cancelAppointment(Long appointmentId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(()->new RuntimeException("Appointment not found"));
        appointmentRepository.delete(appointment);
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
