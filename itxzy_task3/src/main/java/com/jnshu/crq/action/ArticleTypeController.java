package com.jnshu.crq.action;


import com.jnshu.crq.common.response.ResponseBo;
import com.jnshu.crq.model.ArticleType;
import com.jnshu.crq.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;

    @PostMapping("/type")
    public ResponseBo addArtType(@RequestBody ArticleType articleType) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        articleType.setCreateAt(System.currentTimeMillis());
        System.out.println(articleType);
        articleTypeService.addArticeType(articleType);
        responseBo.put("data",articleType);
        return responseBo;
    }

    @DeleteMapping("/type/{id}")
    public ResponseBo delArtType(@PathVariable int id) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        articleTypeService.deleteArticleTypeById(id);
        responseBo.put("data",id);
        return responseBo;
    }

    @PutMapping("/type/{id}")
    public ResponseBo putArtType(@RequestBody ArticleType articleType,@PathVariable int id) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        articleType.setId(id);
        articleTypeService.updateArticleType(articleType);
        responseBo.put("data",id);
        return responseBo;
    }

    @GetMapping("/type/{id}")
    public ResponseBo getArtType(@PathVariable int id) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        ArticleType articleType = articleTypeService.getArticleTypeById(id);
        responseBo.put("data",articleType);
        return responseBo;
    }

    @GetMapping("/type/list/{artClass}")
    public ResponseBo getArtTypeList(@PathVariable int artClass) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        List<ArticleType> list = articleTypeService.getArticleTypeList(artClass);
        responseBo.put("data",list);
        return responseBo;
    }

}
