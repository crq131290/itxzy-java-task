package com.jnshu.crq.mapper;

import com.jnshu.crq.model.Reply;

import java.util.List;

public interface ReplyMapper {
    void insert(Reply reply) throws Exception;

    void delete(int id) throws Exception;

    void update(Reply reply) throws Exception;

    Reply getReply(int id) throws Exception;

    List<Reply> getReplyList(int artId) throws Exception;
}
