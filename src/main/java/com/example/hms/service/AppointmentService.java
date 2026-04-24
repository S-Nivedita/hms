package com.example.hms.service;

import com.example.hms.dto.AppointmentRequest;
import com.example.hms.dto.AppointmentResponse;

import java.util.List;

public interface AppointmentService {
    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId);
    public AppointmentResponse cancelAppointmentByUser(Long AppointmentId);
    public AppointmentResponse cancelAppointmentByDoctor(Long AppointmentId);
    public AppointmentResponse bookAppointment(AppointmentRequest appointmentRequest);
    public List<AppointmentResponse> getAppointmentsByUser(Long UserId);
}
