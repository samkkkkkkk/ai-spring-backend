package com.example.aibackend.dto;

import com.example.aibackend.domain.Employee;
import jakarta.validation.constraints.NotBlank;

public record EmployeeRequest(
        @NotBlank
        String name,
        @NotBlank
        String position,
        @NotBlank
        Long departmentId
) {}
