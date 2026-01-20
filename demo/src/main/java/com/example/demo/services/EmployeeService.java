package com.example.demo.services;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    // CREATE
    public EmployeeDto createEmployee(EmployeeDto dto) {
        EmployeeEntity entity = modelMapper.map(dto, EmployeeEntity.class);
        EmployeeEntity saved = employeeRepository.save(entity);
        return modelMapper.map(saved, EmployeeDto.class);
    }

    // GET BY ID
    public EmployeeDto getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .map(entity -> modelMapper.map(entity, EmployeeDto.class))
                .orElse(null);
    }

    // GET ALL
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, EmployeeDto.class))
                .collect(Collectors.toList());
    }
}
