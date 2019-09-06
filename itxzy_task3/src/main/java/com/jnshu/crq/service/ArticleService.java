package com.jnshu.crq.service;

import com.jnshu.crq.model.Article;

import java.util.List;

/**
 * @author crq131290
 * @title articelDao
 * @description todo
 * @date 2019/08/26
 */
public interface ArticleService {
    int addArticle(Article article) throws Exception;

    int deleteArticleById(int id) throws Exception;

    int updateArticle(Article article) throws Exception;

    Article getArticleById(int id) throws Exception;

    List<Article> getArticleList() throws Exception;

    List<Article> getArticleByUserId(int id) throws Exception;

    List<Article> getArticleByType(int id) throws Exception;
    List<Article> getArticleByKeyword(String keyword) throws Exception;


}
