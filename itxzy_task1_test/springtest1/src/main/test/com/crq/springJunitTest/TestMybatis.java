package com.crq.springJunitTest;

import com.crq.bean.User;
import com.crq.springmybatis.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/ac-mybatis.xml")
public class TestMybatis {
    @Autowired
    private UserDao ud;
    @Test
    public void test1(){
        User u = ud.getUserById(5);
        System.out.println(u);
    }
}
