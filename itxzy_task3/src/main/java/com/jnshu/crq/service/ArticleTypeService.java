package com.jnshu.crq.service;

import com.jnshu.crq.model.ArticleType;

import java.util.List;

/**
 * @author crq131290
 * @title articelTypeService
 * @description todo
 * @date 2019/08/26
 */
public interface ArticleTypeService {
    int addArticeType(ArticleType articleType) throws Exception;

    int deleteArticleTypeById(int id) throws Exception;

    int updateArticleType(ArticleType articleType) throws Exception;

    ArticleType getArticleTypeById(int id) throws Exception;

    List<ArticleType> getArticleTypeList(int artClass) throws Exception;
}
