package com.example.hms.service;

import com.example.hms.dto.AdminResponse;
import com.example.hms.dto.ContactQueryResponse;
import com.example.hms.dto.DashboardResponse;
import com.example.hms.model.Admin;
import com.example.hms.model.ContactQuery;
import com.example.hms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ContactQueryRepository contactQueryRepository;

    public DashboardResponse getDashboardDetails()
    {
        DashboardResponse dashRes = new DashboardResponse();
        dashRes.setUserCount(userRepository.count());
        dashRes.setPatientCount(patientRepository.count());
        dashRes.setDoctorCount(doctorRepository.count());
        return dashRes;
    }

    public AdminResponse loginAdmin(Admin admin)
    {
        Optional<Admin> admin1 = adminRepository.findByUsername(admin.getUsername());
        if(admin1.isPresent())
        {
            if(admin1.get().getPassword().equals(admin.getPassword()))
            {
                return mapToResponse(admin1.get());
            }
            throw new RuntimeException("Invalid Admin Password");
        }
        throw new RuntimeException("Invalid Admin Username");
    }

    public List<ContactQueryResponse> getUnreadContactQueries()
    {
        List<ContactQuery> unreadContactQueries = contactQueryRepository.findAll();
        List<ContactQueryResponse> contactQueryResponses = new ArrayList<>();
        for(ContactQuery contactQuery: unreadContactQueries)
        {
            if(contactQuery.getRead() == false)
            {
                contactQueryResponses.add(mapToContactQueryResponse(contactQuery));
            }
        }
        return contactQueryResponses;
    }

    public List<ContactQueryResponse> getReadContactQueries()
    {
        List<ContactQuery> unreadContactQueries = contactQueryRepository.findAll();
        List<ContactQueryResponse> contactQueryResponses = new ArrayList<>();
        for(ContactQuery contactQuery: unreadContactQueries)
        {
            if(contactQuery.getRead() == true)
            {
                contactQueryResponses.add(mapToContactQueryResponse(contactQuery));
            }
        }
        return contactQueryResponses;
    }

    public ContactQuery getContactQueryById(Long id)
    {
        Optional<ContactQuery> contactQuery = contactQueryRepository.findById(id);
        if(contactQuery.isPresent())
        {
            return contactQuery.get();
        }
        throw new RuntimeException("Contact Query Not Found");
    }

    public String addAdminRemark(Long id , ContactQuery contactQuery)
    {
        Optional<ContactQuery> currentContactQuery = contactQueryRepository.findById(id);
        if(currentContactQuery.isPresent())
        {
            ContactQuery newContactQuery = currentContactQuery.get();
            newContactQuery.setAdminRemark(contactQuery.getAdminRemark());
            newContactQuery.setRead(true);
            contactQueryRepository.save(newContactQuery);
            return "Admin Remark Added Successfully";
        }
        throw new RuntimeException("Contact Query Not Found");
    }

    public ContactQueryResponse mapToContactQueryResponse(ContactQuery contactQuery)
    {
        ContactQueryResponse contactQueryResponse = new ContactQueryResponse();
        contactQueryResponse.setFullName(contactQuery.getFullName());
        contactQueryResponse.setEmail(contactQuery.getEmail());
        contactQueryResponse.setContactNo(contactQuery.getContactNo());
        contactQueryResponse.setMessage(contactQuery.getMessage());
        contactQueryResponse.setPostingDate(contactQuery.getPostingDate());
        return contactQueryResponse;
    }

    public AdminResponse mapToResponse(Admin admin)
    {
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setId(admin.getId());
        adminResponse.setUsername(admin.getUsername());
        adminResponse.setUpdationDate(admin.getUpdationDate());
        return adminResponse;
    }
}
