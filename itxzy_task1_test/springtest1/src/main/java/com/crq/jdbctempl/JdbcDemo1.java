package com.crq.jdbctempl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcDemo1 {
    //C3P0的连接池设定
    //1.准备连接池
    static ComboPooledDataSource dataSource=new ComboPooledDataSource();
    static {
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/itxzy");
            dataSource.setUser("crq131290");
            dataSource.setPassword("root");
            //2.创建JDBC模板对象
            JdbcTemplate jdbcTemplate = new JdbcTemplate();
            jdbcTemplate.setDataSource(dataSource);
            //3.书写sql，并执行
            jdbcTemplate.update("insert into userbean(name,age) values ('李栓但',15)");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        System.out.println("123");
    }
}
