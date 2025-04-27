package com.bootcampproject.controller;

import com.bootcampproject.service.EmployeeService;
import com.bootcampproject.service.requests.CreateEmployeeRequest;
import com.bootcampproject.service.responses.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public void add(@RequestBody CreateEmployeeRequest request) {
        employeeService.add(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CreateEmployeeRequest request) {
        employeeService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

    @GetMapping("/{id}")
    public EmployeeResponse getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        return employeeService.getAll();
    }
}
