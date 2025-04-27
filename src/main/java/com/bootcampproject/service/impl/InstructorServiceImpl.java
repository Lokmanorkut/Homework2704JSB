package com.bootcampproject.service.impl;

import com.bootcampproject.entity.Instructor;
import com.bootcampproject.repository.InstructorRepository;
import com.bootcampproject.service.InstructorService;
import com.bootcampproject.service.requests.CreateInstructorRequest;
import com.bootcampproject.service.responses.InstructorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Override
    public void add(CreateInstructorRequest request) {
        Instructor instructor = new Instructor();
        instructor.setUsername(request.getUsername());
        instructor.setFirstName(request.getFirstName());
        instructor.setLastName(request.getLastName());
        instructor.setEmail(request.getEmail());
        instructor.setPassword(request.getPassword());
        instructor.setCompanyName(request.getCompanyName());
        instructorRepository.save(instructor);
    }

    @Override
    public void update(int id, CreateInstructorRequest request) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow();
        instructor.setUsername(request.getUsername());
        instructor.setCompanyName(request.getCompanyName());
        instructorRepository.save(instructor);
    }

    @Override
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public InstructorResponse getById(int id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow();
        InstructorResponse response = new InstructorResponse();
        response.setId(instructor.getId());
        response.setUsername(instructor.getUsername());
        response.setCompanyName(instructor.getCompanyName());
        return response;
    }

    @Override
    public List<InstructorResponse> getAll() {
        return instructorRepository.findAll()
                .stream()
                .map(instructor -> {
                    InstructorResponse response = new InstructorResponse();
                    response.setId(instructor.getId());
                    response.setUsername(instructor.getUsername());
                    response.setCompanyName(instructor.getCompanyName());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
