package com.example.aibackend.service;

import com.example.aibackend.domain.Department;
import com.example.aibackend.domain.Employee;
import com.example.aibackend.dto.EmployeeRequest;
import com.example.aibackend.error.NotFoundException;
import com.example.aibackend.repository.DepartmentRepository;
import com.example.aibackend.repository.EmployeeRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public void save(EmployeeRequest request) {
        Department department = departmentRepository.findById(request.departmentId())
                .orElseThrow(() -> NotFoundException.of("department", request.departmentId()));

        Employee employee = Employee.builder()
                .name(request.name())
                .position(request.position())
                .department(department)
                .build();

        Employee saved = employeeRepository.save(employee);


    }
}
