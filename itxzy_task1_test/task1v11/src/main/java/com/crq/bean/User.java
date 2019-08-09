package com.crq.bean;

public class User {
    private String name;
    private String age;
    private String id;
    private String qq;

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", id='" + id + '\'' + ", qq='" + qq + '\'' + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
