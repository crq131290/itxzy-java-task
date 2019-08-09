package com.crq.mybatisdao1;

import com.crq.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Title:UserDaoImpl
 * @ProjectName:mybatistest
 * @Descrption:Todo
 * @author crq
 * @date 2019/03/26 22:26
 * */
public class test1 {
    static SqlSessionFactory sessionFactory = null;
    public static void main(String[] args){
        before();
        test(1);
    }

    public static void before(){
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("config/mybatis-configuration.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);//获取sessionFactory
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test(int id){
//        UserDao dao = new UserDaoImpl(sessionFactory);
//        User u = dao.getUserById(id);
//        System.out.println(u);
        UserDao dao = DaoFactory.getUserDao(sessionFactory);
        User u = dao.getUserById(id);
        System.out.println(u);
    }
}
