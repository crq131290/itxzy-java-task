package com.crq.spring2;

import com.crq.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//创建容器
@RunWith(SpringJUnit4ClassRunner.class)

//指定容器使用配置文件
@ContextConfiguration("classpath:config/applicationContext2.xml")
public class TestJunitS {
//   @Resource(name="user")
    @Autowired
    private User u;
    @Test
    public void test1(){
        System.out.println(u);
    }

}
