package com.bootcampproject.service.requests;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String position;
}
