package com.crq.cfx.impl;

import com.crq.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:config/applicationContext3.xml")//这里的classpath不能缺

public class TestCFX {
//    @Autowired
//    private User u;
//    @Test
//    public void test1(){
//        System.out.println(u);
//    }
//    @Autowired
//    private  HelloWebService h;
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext3.xml");

    }
}
