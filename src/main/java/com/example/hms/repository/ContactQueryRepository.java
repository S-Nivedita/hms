package com.example.hms.repository;

import com.example.hms.model.ContactQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContactQueryRepository extends JpaRepository<ContactQuery , Long> {
}
