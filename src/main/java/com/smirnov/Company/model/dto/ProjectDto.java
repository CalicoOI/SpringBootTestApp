package com.smirnov.Company.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ProjectDto {
    private Integer Id;
    private String name;
    private String customer;
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<EmployeeDto> employees;

    public ProjectDto() {
    }

    public ProjectDto(Integer Id, String name, String customer, String description) {
        this.Id = Id;
        this.name = name;
        this.customer = customer;
        this.description = description;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
