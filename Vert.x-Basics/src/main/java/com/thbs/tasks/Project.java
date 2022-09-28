package com.thbs.tasks;

public class Project {
    private Integer projectid;
    private  String projectDetails;

    public Project() {
    }

    public Project(Integer projectid, String projectDetails) {
        this.projectid = projectid;
        this.projectDetails = projectDetails;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    @Override
    public String toString() {
        return
                "projectid=" + projectid +
                ", projectDetails=" + projectDetails ;
    }
}
