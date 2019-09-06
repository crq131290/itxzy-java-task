package com.jnshu.crq.serviceImpl;


import com.jnshu.crq.mapper.ArticleTypeMapper;
import com.jnshu.crq.model.ArticleType;
import com.jnshu.crq.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public int addArticeType(ArticleType articleType) throws Exception {
        articleTypeMapper.insert(articleType);
        return articleType.getId();
    }

    @Override
    public int deleteArticleTypeById(int id) throws Exception {
        articleTypeMapper.delete(id);
        return id;
    }

    @Override
    public int updateArticleType(ArticleType articleType) throws Exception {
        articleTypeMapper.update(articleType);
        return articleType.getId();
    }

    @Override
    public ArticleType getArticleTypeById(int id) throws Exception {
        ArticleType articleType = articleTypeMapper.getArticleType(id);
        return articleType;
    }

    @Override
    public List<ArticleType> getArticleTypeList(int artClass) throws Exception {
        List<ArticleType> list = new ArrayList<>();
        list = articleTypeMapper.getArticleTypeList(artClass);
        return list;
    }
}
