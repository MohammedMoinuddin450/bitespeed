package com.example.assignment.service;

import com.example.assignment.dtos.contactRequestDto;
import com.example.assignment.dtos.contactResponseDto;
import com.example.assignment.repo.idRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class idService {

    private idRepo irepo;

    public contactResponseDto processContact(contactRequestDto request) {
        return null;
    }
}
