package com.crq.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class Car {
    @Value("法拉利")
    protected String name;
    @Value("red")
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", color='" + color + '\'' + '}';
    }
}
