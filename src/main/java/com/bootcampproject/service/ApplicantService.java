package com.bootcampproject.service;

import com.bootcampproject.service.requests.CreateApplicantRequest;
import com.bootcampproject.service.responses.ApplicantResponse;

import java.util.List;

public interface ApplicantService {
    void add(CreateApplicantRequest request);
    void update(int id, CreateApplicantRequest request);
    void delete(int id);
    ApplicantResponse getById(int id);
    List<ApplicantResponse> getAll();
}
