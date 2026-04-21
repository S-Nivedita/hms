package com.example.hms.service;

import com.example.hms.dto.AppointmentResponse;

import java.util.List;

public interface AppointmentService {
    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId);
    public void cancelAppointment(Long appointmentId);

}