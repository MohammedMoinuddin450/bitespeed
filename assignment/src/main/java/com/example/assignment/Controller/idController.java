package com.example.assignment.Controller;

import com.example.assignment.service.idService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identify")
@AllArgsConstructor
public class idController {

    private idService iservice;

}
