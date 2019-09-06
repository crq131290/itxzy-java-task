package com.jnshu.crq.service;

import com.jnshu.crq.model.Banner;

import java.util.List;

/**
 * @author crq131290
 * @title bannerService
 * @description todo
 * @date 2019/08/26
 */
public interface BannerService {
    int addBanner(Banner banner) throws Exception;

    int deleteBannerById(int id) throws Exception;

    int updateBanner(Banner banner) throws Exception;

    Banner getBannerById(int id) throws Exception;

    List<Banner> getBannerList() throws Exception;
}
