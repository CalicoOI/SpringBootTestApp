package com.smirnov.Company.services;

import com.smirnov.Company.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getEmployees();
    EmployeeDto findEmployee(Integer employeeId);
    Integer createEmployee(EmployeeDto employee);
    void updateEmployee(EmployeeDto employee);
    void deleteEmployee(Integer employeeId);
}
