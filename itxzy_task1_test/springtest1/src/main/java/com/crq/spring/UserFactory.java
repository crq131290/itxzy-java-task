package com.crq.spring;

import com.crq.bean.User;

public class UserFactory {
    public static User createUser(){
        System.out.println("静态工厂创建User");
        return new User();//表示由用户自己创建
    }

    public User createUser2(){
        System.out.println("实例工厂创建User");
        return new User();
    }

}

