package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.ArticleMapper;
import com.jnshu.crq.model.Article;
import com.jnshu.crq.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int addArticle(Article article) throws Exception {
        articleMapper.insert(article);
        return article.getId();
    }

    @Override
    public int deleteArticleById(int id) throws Exception {
        articleMapper.delete(id);
        return id;
    }

    @Override
    public int updateArticle(Article article) throws Exception {
        articleMapper.update(article);
        return article.getId();
    }

    @Override
    public Article getArticleById(int id) throws Exception {
        Article article =  articleMapper.getArticle(id);
        return article;
    }

    @Override
    public List<Article> getArticleList() throws Exception {
        List<Article> list = new ArrayList<>();
        list = articleMapper.getArticleList();
        return list;
    }

    @Override
    public List<Article> getArticleByUserId(int id) throws Exception {
        List<Article> list = new ArrayList<>();
        list = articleMapper.getArticleByUserId(id);
        return list;
    }

    @Override
    public List<Article> getArticleByType(int id) throws Exception {
        List<Article> list = new ArrayList<>();
        list = articleMapper.getArticleByType(id);
        return list;
    }

    @Override
    public List<Article> getArticleByKeyword(String keyword) throws Exception {
        List<Article> list = new ArrayList<>();
        System.out.println(keyword+11111);
        list = articleMapper.getArticleByKeyword(keyword);
        return list;
    }
}
