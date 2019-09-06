package com.jnshu.crq.mapper;

import com.jnshu.crq.model.ArticleType;

import java.util.List;

/**
 * @author crq131290
 * @title articelTypeDao
 * @description todo
 * @date 2019/08/26
 */
public interface ArticleTypeMapper {
    void insert(ArticleType articleType) throws Exception;

    void delete(int id) throws Exception;

    void update(ArticleType articleType) throws Exception;

    ArticleType getArticleType(int id) throws Exception;

    List<ArticleType> getArticleTypeList(int artClass) throws Exception;
}
