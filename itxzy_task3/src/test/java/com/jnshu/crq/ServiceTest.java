package com.jnshu.crq;


import com.jnshu.crq.model.User;
import com.jnshu.crq.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {

    private Logger logger = LogManager.getLogger(ServiceTest.class);

    @Autowired
    private UserService userService;
    @Before
    public void before(){
        SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("start:"+start.format(new Date()));
    }

    @After
    public void after(){
        SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("end:"+end.format(new Date()));
    }


    @Test
    public void insert(){
        User user = new User();
        user.setCreateAt(1566918929l);
        user.setName("李栓但");
        user.setUpdateAt(1566918929l);
        user.setEmail("123123@321.com");
        user.setPassword("asdasd");
        user.setPhone("654321");
        user.setSynopsis("李栓但的简介");

        try {
            int id = userService.addUser(user);
            user.setId(id);
            logger.info(id);
            logger.info(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete(){
        try {
            int id = userService.deleteUserById(2);
            logger.info(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(2);
        user.setCreateAt(1566918929l);
        user.setName("李栓但111");
        user.setUpdateAt(1566918929l);
        user.setEmail("123123@321.com111");
        user.setPassword("asdasd111");
        user.setPhone("654321111");
        user.setSynopsis("李栓但的简介123");

        try {
            int id = userService.updateUser(user);
            logger.info(id);
            logger.info(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getUser(){
        try {
            System.out.println("============");
            User user = userService.getUserById(1);
            logger.info(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserList(){
        try {
            List<User> list = userService.getUserList();
            logger.info(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
