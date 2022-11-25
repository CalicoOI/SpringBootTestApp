package com.smirnov.Company.services;

import com.smirnov.Company.model.Project;
import com.smirnov.Company.model.dto.ProjectDto;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectDto> getProjects();
    ProjectDto findProject(String name);
    ProjectDto getProject(Integer projectId);
    Integer createProject(ProjectDto project);
    void updateProject(ProjectDto project);
    void deleteProject(Integer projectId);
}
