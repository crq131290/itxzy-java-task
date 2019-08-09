package com.crq.test;

import com.crq.bean.User;
import com.crq.mybatisdao2.DaoFactory;
import com.crq.mybatisdao2.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Title:UserDaoImpl
 * @ProjectName:mybatistest
 * @Descrption:Todo
 * @author crq
 * @date 2019/03/26 23:55
 * */
public class TestDao2 {
    static SqlSessionFactory sessionFactory = null;
    public static void main(String[] args){
        before();
        test();
    }

    public static void before(){
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatis-configuration.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void test(){
        SqlSession session = sessionFactory.openSession();
//        UserMapper userMapper = session.getMapper(UserMapper.class);
        UserMapper userMapper = DaoFactory.getUserMapper(session);
        //生成usermapper代理对象 会实现UserMapper接口里面的方法
        //如果public User getUserById(Integer id);
        //代理对象就会调用selectone方法
        User u = userMapper.getUserById(1);
        System.out.println(u);

//        SqlSession session = sessionFactory.openSession();
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        User u = userMapper.getUserById(5);
//        System.out.println(u);


    }
}
