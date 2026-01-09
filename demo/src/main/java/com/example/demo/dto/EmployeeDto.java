package com.example.demo.dto;

import com.sun.jdi.Locatable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {
    private Integer id;
    private String name;
    private String email;
    private int age;
    private LocalDate date;
    boolean isActive;

    public EmployeeDto(Integer id, String name, String email, int age, LocalDate date, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.date = date;
        this.isActive = isActive;
    }

}
