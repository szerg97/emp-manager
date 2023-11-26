package com.szalai.empmanager.controller.dto;

public record EmployeeResponse(
        String id,
        String firstName,
        String lastName,
        String position,
        boolean gender
) {}
