package com.szalai.empmanager.service;

import com.szalai.empmanager.controller.dto.EmployeeRequest;
import com.szalai.empmanager.controller.dto.EmployeeResponse;
import com.szalai.empmanager.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public EmployeeResponse fromEntity(Employee employee){
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPosition(),
                employee.isGender()
        );
    }

    public Employee fromRequest(String id, EmployeeRequest request){
        return new Employee(
                id,
                request.firstName(),
                request.lastName(),
                request.position(),
                request.gender()
        );
    }
}
