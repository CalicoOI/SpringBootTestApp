package com.smirnov.Company.model;

public class Employee {
    private Integer EmployeeID;
    private Integer ProjectID;
    private String Firstname;
    private String Lastname;
    private String Email;

    private Project project;

    public Employee() {}

    public Employee(Integer employeeID, Integer projectID, String firstname, String lastname, String email) {
        EmployeeID = employeeID;
        ProjectID = projectID;
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
    }

    public Integer getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        EmployeeID = employeeID;
    }

    public Integer getProjectID() {
        return ProjectID;
    }

    public void setProjectID(Integer projectID) {
        ProjectID = projectID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
