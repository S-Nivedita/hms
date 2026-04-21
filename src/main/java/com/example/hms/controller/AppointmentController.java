package com.example.hms.controller;

import com.example.hms.dto.AppointmentResponse;
import com.example.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointments(@PathVariable Long doctorId){
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctor(doctorId));
    }
    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<String> cancelAppointment(@PathVariable Long appointmentId){
        appointmentService.cancelAppointment(appointmentId);
        return ResponseEntity.ok("Appointment cancelled");
    }
}
