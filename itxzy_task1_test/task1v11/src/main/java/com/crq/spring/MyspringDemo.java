package com.crq.spring;

import com.crq.bean.User;
import com.crq.spring.mytatis.Dao.UserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyspringDemo {
    private static UserDao ud;
    private static ApplicationContext ac;

    public static void main(String [] args){
        ac =new ClassPathXmlApplicationContext("classpath:config/spring/mybatis/spring-ac.xml");
        ud = (UserDao) ac.getBean("userDao");
        User u = new User();
        u.setAge("18");
        u.setQq("111110000");
        u.setName("Dante");

        SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(start.format(new Date()));
        List<User> list =new ArrayList<User>();
        for(int x=0;x<100;x++){
            list.add(u);
        }
//        ComboPooledDataSource db = (ComboPooledDataSource) ac.getBean("dataSource");
//        db.close();
        try{
                ud.addUser(u);
//            ud.bulkAddUser(list);
//            for(int x=0;x<1000;x++){
//                if(x==10){
//                    db.close();
//                }
//            }
        }catch (Exception e){
            System.out.println("catch");
        }finally {
//            db.close();
            System.out.println("finally");
        }


        SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(end.format(new Date()));
    }
}
