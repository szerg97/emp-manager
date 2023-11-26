package com.szalai.empmanager.service;

import com.szalai.empmanager.controller.dto.EmployeeRequest;
import com.szalai.empmanager.controller.dto.EmployeeResponse;
import com.szalai.empmanager.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeMapperTest {

    private EmployeeMapper underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmployeeMapper();
    }

    @Test
    void testFromEntity() {
        String id = UUID.randomUUID().toString();
        String firstName = "Test";
        String lastName = "Test";
        String position = "BA";
        boolean gender = false;
        assertEquals(new EmployeeResponse(
                id, firstName, lastName, position, gender
        ), underTest.fromEntity(new Employee(id, firstName, lastName, position, gender)));
    }

    @Test
    void testFromRequest() {
        String id = UUID.randomUUID().toString();
        String firstName = "Test";
        String lastName = "Test";
        String position = "BA";
        boolean gender = false;
        assertEquals(new Employee(
                id, firstName, lastName, position, gender
        ), underTest.fromRequest(id, new EmployeeRequest(firstName, lastName, position, gender)));
    }
}