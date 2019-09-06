package com.jnshu.crq.action;

import com.jnshu.crq.common.response.ResponseBo;
import com.jnshu.crq.model.Reply;
import com.jnshu.crq.model.User;
import com.jnshu.crq.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping("/detail")
    public ResponseBo addReply(@RequestBody Reply reply) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        reply.setCreateAt(System.currentTimeMillis());
        replyService.addReply(reply);
        responseBo.put("data",reply.getId());
        return responseBo;
    }

    @DeleteMapping("/detail/{id}")
    public ResponseBo delReply(@PathVariable int id) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        replyService.deleteReplyById(id);
        responseBo.put("data",id);
        return responseBo;
    }
    @PutMapping("/detail/{id}")
    public ResponseBo updateReply(@PathVariable int id,@RequestBody Reply reply) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        reply.setId(id);
        replyService.updateReply(reply);
        responseBo.put("data",id);
        return responseBo;
    }
    @GetMapping("/detail/{id}")
    public ResponseBo getReply(@PathVariable int id) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        Reply reply =  replyService.getReplyById(id);
        responseBo.put("data",reply);
        return responseBo;
    }
    @GetMapping("/detail/list/{artId}")
    public ResponseBo getRelyByArt(@PathVariable int artId) throws Exception {
        ResponseBo responseBo = new ResponseBo();
        List<Reply> list =  replyService.getReplyList(artId);
        List<Map> list1 = new ArrayList<>();
        for(Reply r:list){
            Map<String,Object> map = new HashMap<>();
            Map<String,Object> user = new  HashMap<>();
            Map<String,Object> other = new  HashMap<>();
            user.put("id",r.getUser().getId());
            user.put("name",r.getUser().getName());
            if(r.getOther()!=null){
                other.put("id",r.getOther().getId());
                other.put("name",r.getOther().getName());
            }
            map.put("id",r.getId());
            map.put("content",r.getContent());
            map.put("artId",r.getArtId());
            map.put("user",user);
            map.put("other",other);
            list1.add(map);
        }
        System.out.println(list1);
        responseBo.put("data",list1);
        return responseBo;
    }

}
