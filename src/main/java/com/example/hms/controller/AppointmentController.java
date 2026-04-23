package com.example.hms.controller;

import com.example.hms.dto.AppointmentRequest;
import com.example.hms.dto.AppointmentResponse;
import com.example.hms.model.Appointment;
import com.example.hms.service.AppointmentService;
import com.example.hms.service.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService=appointmentService;
    }
    @PostMapping()
    public ResponseEntity<AppointmentResponse> bookAppointment(@RequestBody AppointmentRequest appointmentRequest){
        return ResponseEntity.ok(appointmentService.bookAppointment(appointmentRequest));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(appointmentService.getAppointmentsByUser(userId));
    }
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByDoctorId(@PathVariable Long doctorId){
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctor(doctorId));
    }
    @PatchMapping("{id}/cancel-by-user")
    public ResponseEntity<AppointmentResponse> cancelByUser(@PathVariable Long id){

        return ResponseEntity.ok(appointmentService.cancelAppointmentByUser(id));
    }
    @PatchMapping("{id}/cancel-by-doctor")
    public ResponseEntity<AppointmentResponse> cancelByDoctor(@PathVariable Long id){
        appointmentService.cancelAppointmentByDoctor(id);
        return ResponseEntity.ok(appointmentService.cancelAppointmentByDoctor(id));
    }

}
