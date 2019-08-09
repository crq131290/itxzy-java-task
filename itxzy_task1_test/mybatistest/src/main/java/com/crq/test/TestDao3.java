package com.crq.test;

import com.crq.bean.User;
import com.crq.mybatisdao3.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestDao3 {
    static SqlSessionFactory sessionFactory= null;
    public static void  main(String[] args) throws IOException {
        before();
        test();
    }

    public static void before() throws IOException {
        Reader reader = Resources.getResourceAsReader("config/mybatis-configuration.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static void test(){
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
//        User u2 = new User();
//        u2.setName("dao3");
//        u2.setEmail("dao3.email");
//        userMapper.addUser(u2);
//        session.commit();//更新数据需要commit一下

        User u = userMapper.getUserById(1);
        List<User> list = userMapper.queryUsers();
        System.out.println(u);
        System.out.println(list);
    }
}
