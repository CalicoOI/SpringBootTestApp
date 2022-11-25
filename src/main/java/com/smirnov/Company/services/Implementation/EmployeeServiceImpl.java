package com.smirnov.Company.services.Implementation;

import com.smirnov.Company.configuration.MappingConfiguration;
import com.smirnov.Company.dao.jdbc.EmployeeDaoImplementationJdbc;
import com.smirnov.Company.dao.jdbc.ProjectDaoImplementationJdbc;
import com.smirnov.Company.enums.UserErrors;
import com.smirnov.Company.exception.EntityBaseException;
import com.smirnov.Company.model.Employee;
import com.smirnov.Company.model.Project;
import com.smirnov.Company.model.dto.EmployeeDto;
import com.smirnov.Company.services.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeServiceImpl(EmployeeDaoImplementationJdbc employeeDao, ProjectDaoImplementationJdbc projectDao, MappingConfiguration mappingConfiguration) {
        this.employeeDao = employeeDao;
        this.mappingConfiguration = mappingConfiguration;
        this.projectDao = projectDao;
    }

    private final EmployeeDaoImplementationJdbc employeeDao;
    private final ProjectDaoImplementationJdbc projectDao;
    private final MappingConfiguration mappingConfiguration;

    @Override
    public List<EmployeeDto> getEmployees() {
        List<EmployeeDto> res = new ArrayList<>();
        employeeDao.findAllEmployees()
                .forEach(employee -> res.add(mappingConfiguration.getEmployeeDtoMapper()
                        .map(employee, EmployeeDto.class)));
        return res;
    }

    @Override
    public EmployeeDto findEmployee(Integer employeeId) {
        Optional<Employee> empRes = employeeDao.getEmployeeById(employeeId);
        if (empRes.isPresent()) {
            Optional<Project> empPrj = projectDao.getProject(employeeId);
            Employee res = empRes.get();
            empPrj.ifPresent((project) -> res.setProject(project));
            return mappingConfiguration.getEmployeeDtoMapper()
                    .map(res, EmployeeDto.class);
        }
        else {
            throw new EntityBaseException(UserErrors.EMPLOYEE_NOT_FOUND, employeeId);
        }
    }

    @Override
    public Integer createEmployee(EmployeeDto employee) {
        return employeeDao.createEmployee(mappingConfiguration.getEmployeeMapper().map(employee, Employee.class));
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        if (employeeDao.deleteEmployee(employeeId) == 0)
            throw new EntityBaseException(UserErrors.FAILED_TO_DELETE_EMPLOYEE, employeeId);
    }

    @Override
    public void updateEmployee(EmployeeDto employee) {
        int id = employeeDao.updateEmployee(mappingConfiguration.getEmployeeMapper()
                .map(employee, Employee.class));
        if (id == 0)
            throw new EntityBaseException(UserErrors.FAILED_TO_UPDATE_EMPLOYEE, employee.getId());
    }
}
