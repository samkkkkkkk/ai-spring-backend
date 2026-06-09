package com.example.aibackend.controller;

import com.example.aibackend.dto.EmployeeRequest;
import com.example.aibackend.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createMember(@Valid @RequestBody EmployeeRequest request) {
        employeeService.save(request);
        return ResponseEntity.ok().build();
    }

}
