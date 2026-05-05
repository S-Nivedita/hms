package com.example.hms.controller;

import com.example.hms.security.JwtTokenProvider;
import com.example.hms.dto.AuthResponse;
import com.example.hms.dto.ChangePasswordRequest;
import com.example.hms.dto.ContactQueryResponse;
import com.example.hms.dto.DashboardResponse;
import com.example.hms.model.Admin;
import com.example.hms.model.ContactQuery;
import com.example.hms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private com.example.hms.repository.AdminRepository adminRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

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
    public ResponseEntity<AuthResponse> loginAdmin(@RequestBody Admin admin)
    {
        com.example.hms.model.Admin a = adminRepository.findByUsername(admin.getUsername()).orElseThrow(() -> new RuntimeException("Invalid Admin Username"));
        if (!a.getPassword().equals(admin.getPassword())) throw new RuntimeException("Invalid Admin Password");
        String token = tokenProvider.generateToken(a.getUsername(), "ADMIN", a.getId());
        AuthResponse resp = new AuthResponse();
        resp.setToken(token);
        resp.setRole("ADMIN");
        resp.setUserId(a.getId());
        resp.setEmail(a.getUsername());
        return ResponseEntity.ok(resp);
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

    @PutMapping("/admin/{id}/change-password")
    public ResponseEntity<String> changePassword(@PathVariable Long id, @RequestBody ChangePasswordRequest request)
    {
        adminService.changePassword(id,request);
        return ResponseEntity.ok("Password Changed successfully");
    }
}
