package com.smirnov.Company.dao.api;

import com.smirnov.Company.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> getEmployeesByProjectId(Integer projectId);
}
