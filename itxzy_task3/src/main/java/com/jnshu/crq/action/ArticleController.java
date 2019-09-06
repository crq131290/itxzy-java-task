package com.jnshu.crq.action;

import com.jnshu.crq.common.nickName.NickName;
import com.jnshu.crq.common.response.ResponseBo;
import com.jnshu.crq.model.Article;
import com.jnshu.crq.model.User;
import com.jnshu.crq.service.ArticleService;
import com.jnshu.crq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/detail")
    public ResponseBo articleAdd(@RequestBody Article article) throws Exception {

        articleService.addArticle(article);
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",article);
        return responseBo;
    }

    @DeleteMapping("/detail/{id}")
    public ResponseBo articleDel(@PathVariable(value = "id") int articleId) throws Exception {
        int id = articleService.deleteArticleById(articleId);
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",id);
        return responseBo;
    }

    @PutMapping("/detail/{id}")
    public ResponseBo articleUp(@PathVariable("id") int articleId,@RequestBody Article article) throws Exception {
        article.setId(articleId);
        int id = articleService.updateArticle(article);
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",id);
        return responseBo;
    }

    @GetMapping("/detail/{id}")
    public ResponseBo getArtById(@PathVariable int id) throws Exception {
        Article article = articleService.getArticleById(id);
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",article);
        return responseBo;
    }


    @GetMapping("/detail/list")
    public ResponseBo getArtList() throws Exception {
        List<Article> list = new ArrayList<>();
        list = articleService.getArticleList();
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",list);
        return responseBo;
    }

    @GetMapping("/detail/user/{id}")
    public ResponseBo getArtByUser(@PathVariable int id) throws Exception {
        List<Article> list = new ArrayList<>();
        list = articleService.getArticleByUserId(id);
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",list);
        return responseBo;
    }

    @GetMapping("/detail/type/{id}")
    public ResponseBo getArtByType(@PathVariable int id) throws Exception {
        List<Article> list = new ArrayList<>();
        list = articleService.getArticleByType(id);
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",list);
        return responseBo;
    }

    @GetMapping("/detail/list/{keyword}")
    public ResponseBo getArtByKeyword(@PathVariable String keyword) throws Exception {
        List<Article> list = new ArrayList<>();
        System.out.println(keyword);
        list = articleService.getArticleByKeyword(keyword);
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",list);
        return responseBo;
    }
}
