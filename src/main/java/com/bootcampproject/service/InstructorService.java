package com.bootcampproject.service;

import com.bootcampproject.service.requests.CreateInstructorRequest;
import com.bootcampproject.service.responses.InstructorResponse;

import java.util.List;

public interface InstructorService {
    void add(CreateInstructorRequest request);
    void update(int id, CreateInstructorRequest request);
    void delete(int id);
    InstructorResponse getById(int id);
    List<InstructorResponse> getAll();
}
