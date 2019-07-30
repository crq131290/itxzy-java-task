package com.jnshu.crq.pojo;

public class Student {
    private String name;
    private String qq;
    private int age;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", qq='" + qq + '\'' + ", age=" + age + ", id=" + id + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getQq() {
        return qq;
    }

    public int getAge() {
        return age;
    }
}
