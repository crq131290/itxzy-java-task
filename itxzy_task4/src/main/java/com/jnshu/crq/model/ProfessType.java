package com.jnshu.crq.model;

public class ProfessType {
    private long id;
    private String name;

    @Override
    public String toString() {
        return "ProfessType{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
