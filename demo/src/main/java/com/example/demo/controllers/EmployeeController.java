package com.example.demo.controllers;

import com.example.demo.dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {


      @GetMapping("{employeeId}")
    EmployeeDto getEmployeeById(@PathVariable int employeeId)
      {
          return new EmployeeDto(employeeId,"Divakar","allaboinad658@gmail.com",21, LocalDate.of(2026,1,1),true);
      }
      @GetMapping
      String getEmployees(@RequestParam(required = false) Integer age)
      {
          return "here is the all employees list   "+age;
      }
      @PostMapping
      String hello()
      {
          return "hello from postmapping";
      }




}
