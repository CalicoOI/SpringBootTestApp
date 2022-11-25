package com.smirnov.Company.services.Implementation;

import com.smirnov.Company.configuration.MappingConfiguration;
import com.smirnov.Company.dao.jdbc.EmployeeDaoImplementationJdbc;
import com.smirnov.Company.dao.jdbc.ProjectDaoImplementationJdbc;
import com.smirnov.Company.enums.UserErrors;
import com.smirnov.Company.exception.EntityBaseException;
import com.smirnov.Company.model.Employee;
import com.smirnov.Company.model.Project;
import com.smirnov.Company.model.dto.EmployeeDto;
import com.smirnov.Company.model.dto.ProjectDto;
import com.smirnov.Company.services.ProjectService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    public ProjectServiceImpl(ProjectDaoImplementationJdbc projectDao, EmployeeDaoImplementationJdbc employeeDao, MappingConfiguration mappingConfiguration) {
        this.employeeDao = employeeDao;
        this.mappingConfiguration = mappingConfiguration;
        this.projectDao = projectDao;
    }

    private final EmployeeDaoImplementationJdbc employeeDao;
    private final ProjectDaoImplementationJdbc projectDao;
    private final MappingConfiguration mappingConfiguration;


    @Override
    public List<ProjectDto> getProjects() {
        List<ProjectDto> res = new ArrayList<>();
        projectDao.getProjects()
                .forEach(project -> res.add(mappingConfiguration.getProjectMapper()
                        .map(project, ProjectDto.class)));
        return res;
    }

    @Override
    public ProjectDto findProject(String name) {
        return getProjectBy(projectDao.findProjectByName(name), new EntityBaseException(UserErrors.PROJECT_WITH_NAME_NOT_FOUND, name));
    }

    @Override
    public ProjectDto getProject(Integer projectId) {
        Optional<Project> res = projectDao.getProject(projectId);
        return getProjectBy(res, new EntityBaseException(UserErrors.PROJECT_NOT_FOUND, projectId));
    }

    private ProjectDto getProjectBy(Optional<Project> prjRes, EntityBaseException ex) {
        if (prjRes.isPresent()) {
            List<Employee> prjEmp = employeeDao.getEmployeesByProjectId(prjRes.get().getProjectID());
            List<EmployeeDto> listOfEmpDto = new ArrayList<>();
            prjEmp.forEach(employee -> listOfEmpDto.add(mappingConfiguration.getEmployeeDtoMapper().map(employee, EmployeeDto.class)));
            ProjectDto result = mappingConfiguration.getProjectDtoMapper().map(prjRes.get(), ProjectDto.class);
            result.setEmployees(listOfEmpDto);
            return result;
        }
        else
            throw ex;
    }

    @Override
    public Integer createProject(ProjectDto project) {
        return projectDao.createProject(mappingConfiguration.getProjectMapper().map(project, Project.class));
    }

    @Override
    public void updateProject(ProjectDto project) {
        if (projectDao.updateProject(mappingConfiguration.getProjectMapper().map(project, Project.class)) == 0)
            throw new EntityBaseException(UserErrors.FAILED_TO_UPDATE_PROJECT, project.getId());
    }

    @Override
    public void deleteProject(Integer projectId) {
        if (projectDao.deleteProject(projectId) == 0)
            throw new EntityBaseException(UserErrors.FAILED_TO_DELETE_PROJECT, projectId);
    }
}
