package com.Core_sobes;

import java.util.Objects;

public class POJO implements Cloneable {
    private Long id;
    private String name;

    public POJO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POJO pojo = (POJO) o;
        return id.equals(pojo.id) && name.equals(pojo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public POJO clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (POJO) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
class D {
    public static void main(String[] args) {
        POJO a;
        POJO f = new POJO(2L, "f");
    }
}
