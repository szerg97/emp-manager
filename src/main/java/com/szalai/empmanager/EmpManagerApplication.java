package com.szalai.empmanager;

import com.szalai.empmanager.controller.dto.EmployeeRequest;
import com.szalai.empmanager.controller.dto.EmployeeResponse;
import com.szalai.empmanager.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EmpManagerApplication {

    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmpManagerApplication.class, args);
    }

    @PostConstruct
    public void seed(){
        List<EmployeeResponse> employees = employeeService.addAllEmployees(List.of(
                new EmployeeRequest("Adam", "Apple", "SA", true),
                new EmployeeRequest("Ben", "Brown", "DA", true),
                new EmployeeRequest("Cindy", "Crown", "BI", false)));
        System.out.println(employees);
    }

}
