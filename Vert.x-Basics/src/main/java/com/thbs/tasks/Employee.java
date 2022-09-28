package com.thbs.tasks;

public class Employee {
    private Integer employeeId;
    private String name;
    private String role;
    private Integer projectId;

    public Employee() {}

    public Employee(Integer employeeId, String name, String role, Integer projectId) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.projectId = projectId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }


    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Integer getProjectId() {
        return projectId;
    }


    @Override
    public String toString() {
        return
                "employeeId=" + employeeId +
                ", EmployeeName=" + name +
                ", EmployeeRole=" + role +
                ", projectId=" + projectId ;
    }
}
