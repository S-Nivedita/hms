package com.example.hms.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact_queries")
public class ContactQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    private String email;

    @Column(name = "contact_no")
    private Long contactNo;

    private String message;

    @Column(name = "posting_date" , updatable = false)
    private LocalDateTime postingDate;

    @Column(name = "admin_remark")
    private String adminRemark;

    @Column (name = "last_updation_date")
    private LocalDateTime lastUpdationDate;

    @Column(name = "is_read")
    private Boolean isRead;

    @PrePersist
    void onCreate()
    {
        if(this.postingDate == null)
        {
            this.postingDate = LocalDateTime.now();
        }
        if(this.isRead == null)
        {
            this.isRead = false;
        }
        this.lastUpdationDate = null;
    }

    @PreUpdate
    void onUpdate()
    {
        this.lastUpdationDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDateTime postingDate) {
        this.postingDate = postingDate;
    }

    public String getAdminRemark() {
        return adminRemark;
    }

    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark;
    }

    public LocalDateTime getLastUpdationDate() {
        return lastUpdationDate;
    }

    public void setLastUpdationDate(LocalDateTime lastUpdationDate) {
        this.lastUpdationDate = lastUpdationDate;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }
}
