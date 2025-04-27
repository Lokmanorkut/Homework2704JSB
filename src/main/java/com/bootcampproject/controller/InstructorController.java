package com.bootcampproject.controller;

import com.bootcampproject.service.InstructorService;
import com.bootcampproject.service.requests.CreateInstructorRequest;
import com.bootcampproject.service.responses.InstructorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public void add(@RequestBody CreateInstructorRequest request) {
        instructorService.add(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CreateInstructorRequest request) {
        instructorService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        instructorService.delete(id);
    }

    @GetMapping("/{id}")
    public InstructorResponse getById(@PathVariable int id) {
        return instructorService.getById(id);
    }

    @GetMapping
    public List<InstructorResponse> getAll() {
        return instructorService.getAll();
    }
}
