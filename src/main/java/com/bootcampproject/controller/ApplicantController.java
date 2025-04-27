package com.bootcampproject.controller;

import com.bootcampproject.service.ApplicantService;
import com.bootcampproject.service.requests.CreateApplicantRequest;
import com.bootcampproject.service.responses.ApplicantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@RequiredArgsConstructor
public class ApplicantController {

    private final ApplicantService applicantService;

    @PostMapping
    public void add(@RequestBody CreateApplicantRequest request) {
        applicantService.add(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CreateApplicantRequest request) {
        applicantService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        applicantService.delete(id);
    }

    @GetMapping("/{id}")
    public ApplicantResponse getById(@PathVariable int id) {
        return applicantService.getById(id);
    }

    @GetMapping
    public List<ApplicantResponse> getAll() {
        return applicantService.getAll();
    }
}
