package com.smirnov.Company.model;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Project {
    private Integer ProjectID;
    private String Name;
    private String Customer;
    private String Description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Employee> prjEmployees;

    public Project() {
    }

    public Project(Integer projectID, String name, String customer, String description) {
        ProjectID = projectID;
        Name = name;
        Customer = customer;
        Description = description;
    }

    public Integer getProjectID() {
        return ProjectID;
    }

    public void setProjectID(Integer projectID) {
        ProjectID = projectID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Employee> getPrjEmployees() {
        return prjEmployees;
    }

    public void setPrjEmployees(List<Employee> prjEmployees) {
        this.prjEmployees = prjEmployees;
    }
}
