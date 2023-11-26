package com.szalai.empmanager.controller.dto;

public record EmployeeRequest (
        String firstName,
        String lastName,
        String position,
        boolean gender
) {}
