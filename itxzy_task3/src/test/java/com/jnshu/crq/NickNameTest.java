package com.jnshu.crq;


import com.jnshu.crq.common.nickName.NickName;
import com.jnshu.crq.common.response.ResponseBo;
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
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class NickNameTest {

    private Logger logger = LogManager.getLogger(NickNameTest.class);

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
    public void nickNameTest(){
//        String nickName = NickName.getRandomNickName(2);
//        System.out.println(nickName);
        Random random = new Random();
        String name = NickName.getNickName(random.nextBoolean(),3);
        System.out.println(name);

    }
}
