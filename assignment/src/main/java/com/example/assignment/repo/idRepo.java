package com.example.assignment.repo;

import com.example.assignment.model.contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface idRepo extends JpaRepository<contacts, Integer> {
}
