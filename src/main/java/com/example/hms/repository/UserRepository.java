package com.example.hms.repository;

import com.example.hms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
public User findByEmail(String email);
}
