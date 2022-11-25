package com.smirnov.Company.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.smirnov.Company.model.dto.ProjectDto;

public class EmployeeDto {
    private Integer Id;
    private Integer projectId;
    private String firstName;
    private String lastName;
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProjectDto project;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer Id, Integer projectId, String firstName, String lastName, String email) {
        this.Id = Id;
        this.projectId = projectId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }
}
