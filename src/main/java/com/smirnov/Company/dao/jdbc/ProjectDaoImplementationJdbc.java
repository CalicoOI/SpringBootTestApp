package com.smirnov.Company.dao.jdbc;

import com.smirnov.Company.dao.api.ProjectDao;
import com.smirnov.Company.dao.api.implementation.EntityDaoImplementation;
import com.smirnov.Company.model.Project;
import com.smirnov.Company.model.constants.ProjectConstants;
import com.smirnov.Company.model.mappers.EmployeeRowMapper;
import com.smirnov.Company.model.mappers.ProjectRowMapper;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectDaoImplementationJdbc extends EntityDaoImplementation<Project> implements ProjectDao {
    @Override
    public Optional<Project> getProject(Integer projectId) {
        String queryText = "SELECT * FROM project WHERE ProjectID = :ProjectID";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(ProjectConstants.PROJECT_ID, projectId);
        return getById(queryText, sqlParameterSource, new ProjectRowMapper());
    }

    @Override
    public Optional<Project> findProjectByName(String name) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(ProjectConstants.NAME, name);
        List<Project> results = namedParameterJdbcTemplate
                .query("SELECT * FROM project WHERE PrjName = :PrjName", sqlParameterSource, new ProjectRowMapper());
        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }

    @Override
    public Optional<Project> getProjectEmployees(Integer projectId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(ProjectConstants.PROJECT_ID, projectId);
        Optional<Project> prjResults = Optional.ofNullable(DataAccessUtils.uniqueResult(
                namedParameterJdbcTemplate
                        .query("SELECT * FROM project WHERE ProjectID = :ProjectID", sqlParameterSource, new ProjectRowMapper())));
        prjResults.ifPresent(project -> project.setPrjEmployees(namedParameterJdbcTemplate.query("SELECT * FROM employee WHERE ProjectID = :ProjectID", sqlParameterSource, new EmployeeRowMapper())));
        return prjResults;
    }

    public List<Project> getProjects() {
        return findAll("SELECT * FROM project", new ProjectRowMapper());
    }

    public Integer createProject(Project project) {
        String queryText = "INSERT INTO project (ProjectID, PrjName, PrjCustomer, PrjDescription) VALUES (:ProjectID, :PrjName, :PrjCustomer, :PrjDescription)";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue(ProjectConstants.PROJECT_ID, project.getProjectID())
                .addValue(ProjectConstants.NAME, project.getName())
                .addValue(ProjectConstants.CUSTOMER, project.getCustomer())
                .addValue(ProjectConstants.DESCRIPTION, project.getCustomer());
        return create(project, queryText, sqlParameterSource);
    }

    public Integer updateProject(Project project) {
        String queryText = "UPDATE project SET PrjName = :PrjName, PrjCustomer = :PrjCustomer, PrjDescription = :PrjDescription WHERE ProjectID = :ProjectID";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue(ProjectConstants.PROJECT_ID, project.getProjectID())
                .addValue(ProjectConstants.NAME, project.getName())
                .addValue(ProjectConstants.CUSTOMER, project.getCustomer())
                .addValue(ProjectConstants.DESCRIPTION, project.getCustomer());
        return update(project, queryText, sqlParameterSource);
    }

    public Integer deleteProject(Integer projectId) {
        String queryText = "DELETE FROM project WHERE ProjectID = :ProjectID";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue(ProjectConstants.PROJECT_ID, projectId);
        return delete(queryText, sqlParameterSource);
    }
}
