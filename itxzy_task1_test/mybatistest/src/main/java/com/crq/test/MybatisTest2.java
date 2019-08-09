package com.crq.test;

import java.io.InputStream;

/**
 * @Title:UserDaoImpl
 * @ProjectName:mybatistest
 * @Descrption:Todo
 * @author crq
 * @date 2019/03/26 23:35
 * */
public class MybatisTest2 {
    public InputStream getFile()  {
        InputStream file = null;
        file = getClass().getClassLoader().getResourceAsStream("./config/mybatis-configuration.xml");
        System.out.println(file);
        return file;
    }
}
