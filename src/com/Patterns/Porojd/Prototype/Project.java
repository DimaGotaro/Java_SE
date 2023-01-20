package com.Patterns.Porojd.Prototype;

public class Project implements Copy{
    Integer id;
    String name;
    String source;

    public Project(Integer id, String name, String source) {
        this.id = id;
        this.name = name;
        this.source = source;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public Object copy() {
        return new Project(getId(), getName(), getSource());
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
