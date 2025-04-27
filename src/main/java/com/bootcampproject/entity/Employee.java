package com.bootcampproject.entity;

import com.bootcampproject.core.User;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Employee extends User {
    private String position;
}
