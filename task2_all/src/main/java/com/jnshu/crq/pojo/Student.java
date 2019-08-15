package com.jnshu.crq.pojo;

import com.jnshu.crq.annotation.CannotHaveBlank;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {
    @NotNull(message = "{user.name.isNull}")//这里是有messageSource，由于没指定所以使用系统的local，即中文环境，读取_zh_CN.properties
    private String name;
    private int id;

    @CannotHaveBlank(message = "qq不能有空格")
    private String qq;
    private String skill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
