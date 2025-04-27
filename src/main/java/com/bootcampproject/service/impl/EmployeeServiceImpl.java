package com.bootcampproject.service.impl;

import com.bootcampproject.entity.Employee;
import com.bootcampproject.repository.EmployeeRepository;
import com.bootcampproject.service.EmployeeService;
import com.bootcampproject.service.requests.CreateEmployeeRequest;
import com.bootcampproject.service.responses.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void add(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setUsername(request.getUsername());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());
        employee.setPosition(request.getPosition());
        employeeRepository.save(employee);
    }

    @Override
    public void update(int id, CreateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setUsername(request.getUsername());
        employee.setPosition(request.getPosition());
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setUsername(employee.getUsername());
        response.setPosition(employee.getPosition());
        return response;
    }

    @Override
    public List<EmployeeResponse> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> {
                    EmployeeResponse response = new EmployeeResponse();
                    response.setId(employee.getId());
                    response.setUsername(employee.getUsername());
                    response.setPosition(employee.getPosition());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
