package com.example.hms.service;

import com.example.hms.dto.AdminRequest;
import com.example.hms.dto.AdminResponse;
import com.example.hms.model.Admin;
import com.example.hms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository)
    {
        this.adminRepository = adminRepository;
    }

    /*public AdminResponse registerAdmin(AdminRequest adminRequest)
    {
        Admin newAdmin = new Admin();
        newAdmin.setUsername(adminRequest.getUsername());
        newAdmin.setPassword(adminRequest.getPassword());
        newAdmin.setUpdationDate(null);
        Admin res = adminRepository.save(newAdmin);
        return mapToResponse(res);
    }

    public AdminResponse loginAdmin(AdminRequest adminRequest)
    {
        Admin admin = adminRepository.findById(adminRequest.getId()).orElseThrow(() -> new RuntimeException("Admin Not Found"));
        admin.setUsername(adminRequest.getUsername());
        admin.setPassword(adminRequest.getPassword());
        Admin res = adminRepository.save(admin);
        return mapToResponse(res);
    }

    public AdminResponse mapToResponse(Admin admin)
    {
        AdminResponse adminRes = new AdminResponse();
        adminRes.setId(admin.getId());
        adminRes.setUsername(admin.getUsername());
        adminRes.setUpdationDate(admin.getUpdationDate());
        return adminRes;
    }*/
}
