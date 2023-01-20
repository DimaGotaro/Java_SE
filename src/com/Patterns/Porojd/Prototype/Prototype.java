package com.Patterns.Porojd.Prototype;

public class Prototype {
    public static void main(String[] args) {
        Project project = new Project(1, "Super", "blablablablabla");

        Project copyProject = new ProjectFactory(project).getCopyProject();

        System.out.println(project);
        System.out.println();
        System.out.println(copyProject);
    }
}
