package com.jnshu.crq.action;

import com.jnshu.crq.common.response.ResponseBo;
import com.jnshu.crq.model.Banner;
import com.jnshu.crq.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @PostMapping("/detail")
    public ResponseBo addBanner(@RequestBody Banner banner) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        banner.setCreateAt(System.currentTimeMillis());
        bannerService.addBanner(banner);
        responseBo.put("data",banner);
        return responseBo;
    }

    @DeleteMapping("/detail/{id}")
    public ResponseBo delBanner(@PathVariable int id) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        bannerService.deleteBannerById(id);
        responseBo.put("data",id);
        return responseBo;
    }

    @PutMapping("/detail/{id}")
    public ResponseBo updateBanner(@PathVariable int id,@RequestBody Banner banner) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        banner.setId(id);
        banner.setUpdateAt(System.currentTimeMillis());
        bannerService.updateBanner(banner);
        responseBo.put("data",id);
        return responseBo;
    }

    @GetMapping("/detail/{id}")
    public ResponseBo getBanner(@PathVariable int id) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        Banner banner =  bannerService.getBannerById(id);
        responseBo.put("data",banner);
        return responseBo;
    }

    @GetMapping("/detail/list")
    public ResponseBo getBannerList() throws Exception {
        ResponseBo responseBo = new ResponseBo();
        List<Banner> list = bannerService.getBannerList();
        responseBo.put("data",list);
        return responseBo;
    }
}
