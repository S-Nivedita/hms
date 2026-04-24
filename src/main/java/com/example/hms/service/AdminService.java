package com.example.hms.service;

import com.example.hms.dto.AdminResponse;
import com.example.hms.dto.ContactQueryResponse;
import com.example.hms.dto.DashboardResponse;
import com.example.hms.model.Admin;
import com.example.hms.model.ContactQuery;

import java.util.List;

public interface AdminService {
    public DashboardResponse getDashboardDetails();
    public AdminResponse loginAdmin(Admin admin);
    public List<ContactQueryResponse> getUnreadContactQueries();
    public List<ContactQueryResponse> getReadContactQueries();
    public ContactQuery getContactQueryById(Long id);
    public String addAdminRemark(Long id, ContactQuery contactQuery);
}
