package com.crq.jdbcTest;

import com.crq.jdbctempl.Dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:config/applicationContext4.xml")
public class TestJdbctmpl {

    @Autowired
    private UserDao ud;
    @Test
    public void test1(){
        System.out.println(ud.getUserById("1"));
    }
}
