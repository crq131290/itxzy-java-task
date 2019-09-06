package com.jnshu.crq.mapper;

import com.jnshu.crq.model.Banner;

import java.util.List;

/**
 * @author crq131290
 * @title bannerDao
 * @description todo
 * @date 2019/08/26
 * */
public interface BannerMapper {
    void insert(Banner banner) throws Exception;

    void delete(int id) throws Exception;

    void update(Banner banner) throws Exception;

    Banner getBanner(int id) throws Exception;

    List<Banner> getBannerList() throws Exception;
}
