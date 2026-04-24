package com.example.hms.repository;

import com.example.hms.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin , Long> {
    public Optional<Admin> findByUsername(String username);
}
