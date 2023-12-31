package com.example.employeemanagement_backend.controller;

import com.example.employeemanagement_backend.exception.ResourceNotFoundException;
import com.example.employeemanagement_backend.model.Employee;
import com.example.employeemanagement_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return  employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id"+id));
        return  ResponseEntity.ok(employee);

    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable Long id,@RequestBody Employee employeeDetails){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id"+id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        Employee updateemployee=employeeRepository.save(employee);
        return  ResponseEntity.ok(updateemployee);

    }
}
