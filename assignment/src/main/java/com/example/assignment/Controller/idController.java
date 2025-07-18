package com.example.assignment.Controller;

import com.example.assignment.dtos.contactRequestDto;
import com.example.assignment.dtos.contactResponseDto;
import com.example.assignment.service.idService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/bitespeed")
@AllArgsConstructor
public class idController {

    private idService iservice;

    @PostMapping("/identify")
    public ResponseEntity<Map<String, contactResponseDto>> identify(@RequestBody contactRequestDto request) {
        contactResponseDto response = iservice.processContact(request);
        return ResponseEntity.ok(Map.of("contact", response));
    }

}
