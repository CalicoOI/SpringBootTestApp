package com.smirnov.Company.model.mappers;

import com.smirnov.Company.model.Employee;
import com.smirnov.Company.model.constants.EmployeeConstants;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeID(resultSet.getInt(EmployeeConstants.EMPLOYEE_ID));
        employee.setProjectID(resultSet.getInt(EmployeeConstants.PROJECT_ID));
        employee.setFirstname(resultSet.getString(EmployeeConstants.FIRST_NAME));
        employee.setLastname(resultSet.getString(EmployeeConstants.LAST_NAME));
        employee.setEmail(resultSet.getString(EmployeeConstants.EMAIL));
        return employee;
    }
}