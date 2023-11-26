package com.szalai.empmanager.controller;

import com.szalai.empmanager.controller.dto.EmployeeRequest;
import com.szalai.empmanager.controller.dto.EmployeeResponse;
import com.szalai.empmanager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getOneEmployee(@PathVariable String id){
        return ResponseEntity.ok(employeeService.findOneEmployee(id));
    }

    @PostMapping("")
    public ResponseEntity<EmployeeResponse> addOneEmployee(@RequestBody EmployeeRequest request){
        return ResponseEntity.ok(employeeService.addOneEmployee(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeResponse> deleteOneEmployee(@PathVariable String id){
        return ResponseEntity.ok(employeeService.deleteOneEmployee(id));
    }
}
