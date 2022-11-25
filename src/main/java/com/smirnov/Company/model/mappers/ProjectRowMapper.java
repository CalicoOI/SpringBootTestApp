package com.smirnov.Company.model.mappers;

import com.smirnov.Company.model.Project;
import com.smirnov.Company.model.constants.ProjectConstants;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Project project = new Project();
        project.setProjectID(resultSet.getInt(ProjectConstants.PROJECT_ID));
        project.setName(resultSet.getString(ProjectConstants.NAME));
        project.setCustomer(resultSet.getString(ProjectConstants.CUSTOMER));
        project.setDescription(resultSet.getString(ProjectConstants.DESCRIPTION));

        return project;
    }
}