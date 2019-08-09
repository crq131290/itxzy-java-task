package com.crq.spring;

import com.crq.bean.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;

public class TestUser {
    private static ApplicationContext ac = null;
    private static BeanContext bc = null;
    @BeforeClass
    public static void setAc(){
        //1.创建容器对象，相对于src下的路径
        ac = new ClassPathXmlApplicationContext("config/index2.xml");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:config/applicationContext.xml");
        System.out.println(res);
        BeanFactory factory = new XmlBeanFactory(res);

        User user = factory.getBean("user",User.class);
        System.out.println(user);
    }
    @Test
    public void test(){
        //2.向容器“要”user对象
        User u=(User) ac.getBean("user2");
        //3.打印user对象
        System.out.println(u);
    }

    @Test
    public void testStaticFac(){
        User u = (User) ac.getBean("user3");
        System.out.println("user3:"+u);
    }

    @Test
    public void testInstanceFac(){
        User u  = (User) ac.getBean("user4");
        System.out.println("user4:"+u);
    }

    @Test
    public void testSingleUser(){
        User u1 = (User) ac.getBean("userSingle");
        User u2 = (User) ac.getBean("userSingle");
        System.out.println("u1==u2:"+(u1==u2));

    }

    @Test
    public void testInit(){
        User u = (User) ac.getBean("userInit");
        System.out.println("testInit");

    }

    @Test
    public void testConsUser(){
        User u = (User) ac.getBean("consUser");
        System.out.println("consu:"+u);
    }
    @Test
    public void testPUser(){
        User u = (User) ac.getBean("userp");
        System.out.println("userp:"+u);
    }
     @Test
    public void testUserSpel(){
        User u = (User) ac.getBean("userSpel");
        System.out.println("userSpel:"+u);
    }

    @Test
    public void testCB(){
        CollectionBean cb = (CollectionBean) ac.getBean("cb");
        System.out.println("cb.arr:"+Arrays.toString(cb.getArr()));
        System.out.println("cb.map:"+cb.getMap());
        System.out.println("cb.list:"+cb.getList());
        System.out.println("cb.prop:"+cb.getProp());

    }






}
