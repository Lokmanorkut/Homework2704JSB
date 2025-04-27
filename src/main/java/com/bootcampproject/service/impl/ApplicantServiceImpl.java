package com.bootcampproject.service.impl;

import com.bootcampproject.entity.Applicant;
import com.bootcampproject.repository.ApplicantRepository;
import com.bootcampproject.service.ApplicantService;
import com.bootcampproject.service.requests.CreateApplicantRequest;
import com.bootcampproject.service.responses.ApplicantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    @Override
    public void add(CreateApplicantRequest request) {
        Applicant applicant = new Applicant();
        applicant.setUsername(request.getUsername());
        applicant.setFirstName(request.getFirstName());
        applicant.setLastName(request.getLastName());
        applicant.setEmail(request.getEmail());
        applicant.setPassword(request.getPassword());
        applicant.setAbout(request.getAbout());
        applicantRepository.save(applicant);
    }

    @Override
    public void update(int id, CreateApplicantRequest request) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        applicant.setUsername(request.getUsername());
        applicant.setAbout(request.getAbout());
        applicantRepository.save(applicant);
    }

    @Override
    public void delete(int id) {
        applicantRepository.deleteById(id);
    }

    @Override
    public ApplicantResponse getById(int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        ApplicantResponse response = new ApplicantResponse();
        response.setId(applicant.getId());
        response.setUsername(applicant.getUsername());
        response.setAbout(applicant.getAbout());
        return response;
    }

    @Override
    public List<ApplicantResponse> getAll() {
        return applicantRepository.findAll()
                .stream()
                .map(applicant -> {
                    ApplicantResponse response = new ApplicantResponse();
                    response.setId(applicant.getId());
                    response.setUsername(applicant.getUsername());
                    response.setAbout(applicant.getAbout());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
