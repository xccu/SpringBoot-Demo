package com.example.springdata.demo.repository;

import com.example.springdata.demo.model.AuditUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AuditUserRepository extends JpaRepository<AuditUser, Integer> {
}
