package com.example.demo.controllers;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("{employeeId}")
    EmployeeEntity getEmployeeById(@PathVariable int employeeId)
      {
          return employeeRepository.findById(employeeId).orElse(null);
      }
      @GetMapping
      public List<EmployeeEntity> getEmployees(@RequestParam(required = false) Integer age)
      {
          return employeeRepository.findAll();
      }
      @PostMapping
      public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployeeEntity)
      {
            return employeeRepository.save(inputEmployeeEntity);
      }






}
