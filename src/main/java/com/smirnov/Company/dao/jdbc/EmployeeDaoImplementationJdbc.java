package com.smirnov.Company.dao.jdbc;

import com.smirnov.Company.dao.api.EmployeeDao;
import com.smirnov.Company.dao.api.implementation.EntityDaoImplementation;
import com.smirnov.Company.model.Employee;
import com.smirnov.Company.model.constants.EmployeeConstants;
import com.smirnov.Company.model.mappers.EmployeeRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImplementationJdbc extends EntityDaoImplementation<Employee> implements EmployeeDao {
    @Override
    public List<Employee> getEmployeesByProjectId(Integer projectId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(EmployeeConstants.PROJECT_ID, projectId);
        return namedParameterJdbcTemplate.query("SELECT * FROM employee WHERE ProjectID = :ProjectID", sqlParameterSource, new EmployeeRowMapper());
    }

    public Optional<Employee> getEmployeeById(Integer Id) {
        String queryText = "SELECT * FROM employee WHERE EmployeeID = :EmployeeID";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(EmployeeConstants.EMPLOYEE_ID, Id);
        return getById(queryText, sqlParameterSource, new EmployeeRowMapper());
    }

    public List<Employee> findAllEmployees() {
        return findAll("SELECT * FROM employee", new EmployeeRowMapper());
    }

    public Integer createEmployee(Employee employee) {
        String queryText = "INSERT INTO employee (ProjectID, FirstName, LastName, Email) VALUES (:ProjectID, :FirstName, :LastName, :Email)";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue(EmployeeConstants.PROJECT_ID, employee.getProjectID())
                .addValue(EmployeeConstants.FIRST_NAME, employee.getFirstname())
                .addValue(EmployeeConstants.LAST_NAME, employee.getLastname())
                .addValue(EmployeeConstants.EMAIL, employee.getEmail());
        return create(employee, queryText, sqlParameterSource);
    }

    public Integer updateEmployee(Employee employee) {
        String queryText = "UPDATE employee SET ProjectID = :ProjectID, FirstName = :FirstName, LastName = :LastName, Email = :Email WHERE EmployeeID = :EmployeeID";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue(EmployeeConstants.EMPLOYEE_ID, employee.getEmployeeID())
                .addValue(EmployeeConstants.PROJECT_ID, employee.getProjectID())
                .addValue(EmployeeConstants.FIRST_NAME, employee.getFirstname())
                .addValue(EmployeeConstants.LAST_NAME, employee.getLastname())
                .addValue(EmployeeConstants.EMAIL, employee.getEmail());
        return update(employee, queryText, sqlParameterSource);
    }

    public Integer deleteEmployee(Integer employeeId) {
        String queryText = "DELETE FROM employee WHERE EmployeeID = :EmployeeID";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue(EmployeeConstants.EMPLOYEE_ID, employeeId);
        return delete(queryText, sqlParameterSource);
    }
}
