package com.jnshu.crq;


import com.jnshu.crq.model.Article;
import com.jnshu.crq.model.User;
import com.jnshu.crq.service.ArticleService;
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
public class ArticleServiceTest {

    private Logger logger = LogManager.getLogger(ArticleServiceTest.class);

    @Autowired
    private ArticleService articleService;
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
        Article article = new Article();

        article.setCreateAt(12313123L);
        article.setUpdateAt(33333333L);
        article.setImg("asdasdasd.png");
        article.setUserId(1);
        article.setTime(1111111111111L);
        article.setName("作品名称");
        article.setType(1);
        article.setSynopsis("作品简介");
        article.setArtClass("作品分类");

        try {
            int id = articleService.addArticle(article);
            logger.info(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void delete(){
        try {
            int id = articleService.deleteArticleById(2);
            logger.info(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update(){
        Article article = new Article();
        article.setId(3);
        article.setArtClass("摄影");
        article.setCreateAt(666L);
        article.setUpdateAt(666L);
        article.setImg("aaaa.png");
        article.setUserId(2);
        article.setTime(11111111L);
        article.setName("作品名称1");
        article.setType(2);
        article.setSynopsis("作品简介2");
        article.setArtClass("作品分类3");
        try {
            int id = articleService.updateArticle(article);
            logger.info(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getArticle(){
        try {
            Article article = articleService.getArticleById(1);
            logger.info(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getArticleList(){
        try {
            List<Article> list = articleService.getArticleList();
            logger.info(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
