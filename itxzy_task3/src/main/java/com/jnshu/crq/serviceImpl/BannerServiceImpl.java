package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.BannerMapper;
import com.jnshu.crq.model.Banner;
import com.jnshu.crq.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public int addBanner(Banner banner) throws Exception {
        bannerMapper.insert(banner);
        return banner.getId();
    }

    @Override
    public int deleteBannerById(int id) throws Exception {
        bannerMapper.delete(id);
        return id;
    }

    @Override
    public int updateBanner(Banner banner) throws Exception {
        bannerMapper.update(banner);
        return banner.getId();
    }

    @Override
    public Banner getBannerById(int id) throws Exception {
        Banner banner = bannerMapper.getBanner(id);
        return banner;
    }

    @Override
    public List<Banner> getBannerList() throws Exception {
        List<Banner> list = bannerMapper.getBannerList();
        return list;
    }
}
