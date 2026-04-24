package com.example.hms.controller;

import com.example.hms.dto.AdminRequest;
import com.example.hms.dto.AdminResponse;
import com.example.hms.dto.ContactQueryResponse;
import com.example.hms.dto.DashboardResponse;
import com.example.hms.model.Admin;
import com.example.hms.model.ContactQuery;
import com.example.hms.repository.AdminRepository;
import com.example.hms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/admin/dashboard")
    public ResponseEntity<DashboardResponse> getDashboardDetails()
    {
        return ResponseEntity.ok(adminService.getDashboardDetails());
    }

    @PostMapping("/auth/admin/login")
    public ResponseEntity<AdminResponse> loginAdmin(@RequestBody Admin admin)
    {
        return ResponseEntity.ok(adminService.loginAdmin(admin));
    }

    @GetMapping("/admin/contact-queries/unread")
    public ResponseEntity<List<ContactQueryResponse>> getUnreadContactQueries()
    {
        return ResponseEntity.ok(adminService.getUnreadContactQueries());
    }

    @GetMapping("/admin/contact-queries/read")
    public ResponseEntity<List<ContactQueryResponse>> getReadContactQueries()
    {
        return ResponseEntity.ok(adminService.getReadContactQueries());
    }

    @GetMapping("/admin/contact-queries/{id}")
    public ResponseEntity<ContactQuery> getContactQueryById(@PathVariable Long id)
    {
        return ResponseEntity.ok(adminService.getContactQueryById(id));
    }

    @PatchMapping("/admin/contact-queries/{id}/remark")
    public ResponseEntity<String> addAdminRemark(@PathVariable Long id, @RequestBody ContactQuery contactQuery)
    {
        return ResponseEntity.ok(adminService.addAdminRemark(id, contactQuery));
    }
}
