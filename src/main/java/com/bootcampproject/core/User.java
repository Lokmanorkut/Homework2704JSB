package com.bootcampproject.core;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
}
