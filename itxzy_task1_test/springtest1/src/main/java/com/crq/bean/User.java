package com.crq.bean;

import com.crq.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Title :     bean对象
 * @ProjectName:    springtest
 * @author :    crq
 * @Date:   2019/03/30 00:50
 * @Description:    TODO
 * */
@Component//这四个注解完全一样，以下三个只是为了分层
//    @Service("user")//Service层
//    @Controller("user")//Web层
//    @Repository("user") //Dao层
    @Scope (scopeName = "prototype")
public class User {
        //方法一
        @Value("tom")//加到成员变量上，通过反射的Field赋值，破坏封装性
    private String name;
    private String age;
    private String id;
    private String qq;
    @Autowired//自动装配
    //问题，如果匹配多个类型一致的对象，将无法选择具体注入哪一对象
    @Qualifier("car")//使用@Qualifier注解告诉spring容器自动装配哪个名称的对象
//    @Resource(name="car") //手动注入，指定注入哪个名称的对象
    private Car car;

    public User(){}
    public User(String name,String age,Car car){
        this.name = name;
        this.age=age;
        this.car = car;
    }
    public String getName() {
        return name;
    }
        @Value("Dante")//通过set方法赋值
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

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", id='" + id + '\'' + ", qq='" + qq + '\'' + ", car=" + car + '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    void userInit(){
        System.out.println("userInit");
    }


    @PostConstruct //在对象被创建之后调用，init-method
    public void init() {
        System.out.println("初始化");
    }
    @PreDestroy //在对象销毁之前调用，destroy-method
    public void destroy() {
        System.out.println("销毁");
    }
}
