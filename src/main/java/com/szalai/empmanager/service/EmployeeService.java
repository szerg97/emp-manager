package com.szalai.empmanager.service;

import com.szalai.empmanager.controller.dto.EmployeeRequest;
import com.szalai.empmanager.controller.dto.EmployeeResponse;
import com.szalai.empmanager.model.Employee;
import com.szalai.empmanager.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public List<EmployeeResponse> findAllEmployees(){
        return repository.findAll().stream().map(mapper::fromEntity).toList();
    }

    public EmployeeResponse findOneEmployee(final String id){
        return repository.findById(id).map(mapper::fromEntity).orElseThrow();
    }

    public EmployeeResponse addOneEmployee(final EmployeeRequest request){
        final String id = UUID.randomUUID().toString();
        repository.save(mapper.fromRequest(id, request));
        return repository.findById(id).map(mapper::fromEntity).orElseThrow();
    }

    public List<EmployeeResponse> addAllEmployees(final Collection<EmployeeRequest> request){
        final List<EmployeeResponse> employeesToReturn = new ArrayList<>();
        request.forEach(req -> {
            final String id = UUID.randomUUID().toString();
            Employee emp = repository.save(mapper.fromRequest(id, req));
            employeesToReturn.add(mapper.fromEntity(emp));
        });

        return employeesToReturn;
    }

    public EmployeeResponse deleteOneEmployee(final String id){
        final Employee employee = repository.findById(id).orElseThrow();
        repository.delete(employee);
        return mapper.fromEntity(employee);
    }
}
