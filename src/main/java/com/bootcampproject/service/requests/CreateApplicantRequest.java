package com.bootcampproject.service.requests;

import lombok.Data;

@Data
public class CreateApplicantRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String about;
}
