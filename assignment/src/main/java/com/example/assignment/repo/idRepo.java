package com.example.assignment.repo;

import com.example.assignment.model.contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface idRepo extends JpaRepository<contacts, Integer> {
    List<contacts> findByEmailOrPhoneNumber(String email, String phoneNumber);
}
