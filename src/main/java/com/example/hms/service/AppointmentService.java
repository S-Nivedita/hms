package com.example.hms.service;

import com.example.hms.dto.AppointmentRequest;
import com.example.hms.dto.AppointmentResponse;

import java.util.List;

public interface AppointmentService {
    List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId);
    AppointmentResponse cancelAppointmentByUser(Long AppointmentId);
    AppointmentResponse cancelAppointmentByDoctor(Long AppointmentId);
    AppointmentResponse bookAppointment(AppointmentRequest appointmentRequest);
    List<AppointmentResponse> getAppointmentsByUser(Long UserId);
}