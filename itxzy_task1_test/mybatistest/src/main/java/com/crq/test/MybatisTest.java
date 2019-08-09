package com.crq.test;

import com.crq.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/*
* Resources 类为从类路径中加载资源，提供了易于使用的方法
* Resources 类常用于以下几种情况
*    1.从类路径加载 SQL Map 配置文件（如 sqlMap-config.xml）。
    2. 从类路径加载 DAO Manager 配置文件（如 dao.xml）。
    3. 从类路径加载各种.properties 文件。
*
* */
/**
 * @Title:UserDaoImpl
 * @ProjectName:mybatistest
 * @Descrption:Todo
 * @author crq
 * @date 2019/03/26 22:26
 * */
public class MybatisTest {
    public static void main(String[] args){
//        MybatisTest2 t2 = new MybatisTest2();
//        InputStream r2 =  t2.getFile();
        try {
//            mybatis-configuration.xml包含Mapper文件
//                                            |--包含sql语句
            Reader reader = Resources.getResourceAsReader("config/mybatis-configuration.xml");
//            InputStream reader = Resources.getResourceAsStream("config/mybatis-configuration.xml");
            //        读取配置文件mybatis-configuration.xml，生成sessionFactory
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            SqlSession会根据statement，去执行相应的方法，这些方法会返回相应的结果，结果类型咱们可以指定在mapper中
            SqlSession  session = sessionFactory.openSession();
            String statement = "com.crq.bean.userMapper"+".selectUserById";
            User u = session.selectOne(statement,1);
            System.out.println(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
