package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.ReplyMapper;
import com.jnshu.crq.model.Reply;
import com.jnshu.crq.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public int addReply(Reply reply) throws Exception {
        replyMapper.insert(reply);
        return reply.getId();
    }

    @Override
    public Boolean deleteReplyById(int id) throws Exception {
        replyMapper.delete(id);
        return id>0;
    }

    @Override
    public Boolean updateReply(Reply reply) throws Exception {
        replyMapper.update(reply);
        return reply.getId()>0;
    }

    @Override
    public Reply getReplyById(int id) throws Exception {
        Reply reply = replyMapper.getReply(id);
        return reply;
    }

    @Override
    public List<Reply> getReplyList(int artId) throws Exception {
        List<Reply> list = replyMapper.getReplyList(artId);
        return list;
    }
}
