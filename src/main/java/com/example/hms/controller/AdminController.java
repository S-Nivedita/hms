package com.example.hms.controller;

import com.example.hms.dto.AdminRequest;
import com.example.hms.dto.AdminResponse;
import com.example.hms.model.Admin;
import com.example.hms.repository.AdminRepository;
import com.example.hms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    public AdminController(AdminService adminService)
    {
        this.adminService = adminService;
    }

    /*@PostMapping("/admin/login")
    public ResponseEntity<Map<String , Object>> adminLogin(@RequestBody Admin admin)
    {
        Integer id = admin.getId();
        Admin data = null;
        if(id != null)
        {
             data = adminRepository.findById(id).orElse(new Admin());
        }
        return ResponseEntity.ok(Map.of("success" , true , "data" , toResponse(data)));
    }

    @PostMapping("/admin/register")
    public ResponseEntity<AdminResponse> adminRegister(@RequestBody AdminRequest adminRequest)
    {
        return ResponseEntity.ok(adminService.registerAdmin(adminRequest));
    }

    @PostMapping("/admin/login")
    public ResponseEntity<AdminResponse> adminLogin(@RequestBody AdminRequest adminRequest)
    {
        return ResponseEntity.ok(adminService.loginAdmin(adminRequest));
    }*/

    /*private Map<String , Object> toResponse(Admin admin)
    {
        return Map.of(
                "id", admin.getId(),
                "username" , admin.getUsername(),
                "updation_date", admin.getUpdationDate() == null?"":admin.getUpdationDate()

        );
    }*/
}
