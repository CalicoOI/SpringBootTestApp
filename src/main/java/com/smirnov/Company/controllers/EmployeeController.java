package com.smirnov.Company.controllers;

import com.smirnov.Company.model.dto.EmployeeDto;
import com.smirnov.Company.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.FOUND);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployee(@PathVariable Integer employeeId) {
        return new ResponseEntity<>(employeeService.findEmployee(employeeId), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employee) {
        return new ResponseEntity<>(String.format("New employee Id = %d", employeeService.createEmployee(employee)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employee) {
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
     }
}
