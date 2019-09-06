package com.jnshu.crq.mapper;

import com.jnshu.crq.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author crq131290
 * @title articelDao
 * @description todo
 * @date 2019/08/26
 */
public interface ArticleMapper {
    void insert(Article article) throws Exception;

    void delete(int id) throws Exception;

    void update(Article article) throws Exception;

    Article getArticle(int id) throws Exception;

    List<Article> getArticleList() throws Exception;

    List<Article> getArticleByUserId(int userId) throws Exception;
    List<Article> getArticleByType(int userId) throws Exception;

    List<Article> getArticleByKeyword(@Param("keyword") String keyword) throws Exception;


}
