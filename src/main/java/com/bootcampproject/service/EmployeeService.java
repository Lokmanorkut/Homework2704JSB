package com.bootcampproject.service;

import com.bootcampproject.service.requests.CreateEmployeeRequest;
import com.bootcampproject.service.responses.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    void add(CreateEmployeeRequest request);
    void update(int id, CreateEmployeeRequest request);
    void delete(int id);
    EmployeeResponse getById(int id);
    List<EmployeeResponse> getAll();
}
