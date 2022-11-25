package com.smirnov.Company.dao.api;

import com.smirnov.Company.model.Project;

import java.util.Optional;

public interface ProjectDao {
    Optional<Project> getProject(Integer projectId);
    Optional<Project> findProjectByName(String name);
    Optional<Project> getProjectEmployees(Integer projectId);

}
