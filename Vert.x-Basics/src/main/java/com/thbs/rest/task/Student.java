package com.thbs.rest.task;

public class Student {
    private Integer rollNo;
    private String name;
    private String grade;

    public Student() {
    }

    public Student(Integer rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return
                "rollNo=" + rollNo +
                " name=" + name  +
                " grade=" + grade ;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
