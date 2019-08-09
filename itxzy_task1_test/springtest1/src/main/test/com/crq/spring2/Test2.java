package com.crq.spring2;

import com.crq.bean.Car;
import com.crq.bean.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    private static ApplicationContext ac = null;
    @BeforeClass
    public static void beforeClass(){
        ac = new ClassPathXmlApplicationContext("config/applicationContext2.xml");
    }

    @Test
    public void test1(){
        User u = (User) ac.getBean("user");
        User u2 = (User) ac.getBean("user");
        Car car = (Car) ac.getBean("car");
        System.out.println(u);
        System.out.println(car);
    }




}
