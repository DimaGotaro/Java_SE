package com.Patterns.Porojd.Prototype;

public class ProjectFactory {
    Project project;

    public ProjectFactory(Project project) {
        this.project = project;
    }

    public Project getCopyProject() {
        return (Project) project.copy();
    }
}
