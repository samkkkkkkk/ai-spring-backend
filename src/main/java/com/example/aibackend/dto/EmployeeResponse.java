package com.example.aibackend.dto;

import com.example.aibackend.domain.Employee;

import java.time.LocalDateTime;

public record EmployeeResponse(
        Long id,
        String name,
        String position,
        Long departmentId,
        String departmentName,
        LocalDateTime joinedAt
) {

    public static EmployeeResponse from(Employee employee) {
        return new EmployeeResponse(employee.getId(),
                                    employee.getName(), employee.getPosition(),
                                    employee.getDepartment().getId(),
                                    employee.getDepartment().getName(),
                                    employee.getJoined_at());
    }

}
