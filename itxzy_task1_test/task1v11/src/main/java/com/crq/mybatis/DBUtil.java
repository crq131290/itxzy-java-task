package com.crq.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBUtil {
    public static Reader in;
//    public static
    static {
        try {
           in =  Resources.getResourceAsReader("config/mybatis/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession open() {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        return  sessionFactory.openSession();
    }
    public  static void close(SqlSession session){
        if(session!=null)
            session.close();
    }
    public  static void commit(SqlSession session){
        if(session!=null)
            session.commit();
    }
}
