package com.thbs.task.mysqlclient;

import java.util.Objects;

public class Employee {
    private Integer id;
    private String name;
    private String dob;
    private String qualification;
    private String details;

    public Employee() {
    }

    public Employee(Integer id, String name, String dob, String qualification, String details) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.qualification = qualification;
        this.details = details;
    }

    public Employee( String name, String dob, String qualification, String details) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.qualification = qualification;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(dob, employee.dob) && Objects.equals(qualification, employee.qualification) && Objects.equals(details, employee.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob, qualification, details);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", qualification='" + qualification + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
