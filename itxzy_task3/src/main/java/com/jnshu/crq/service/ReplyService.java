package com.jnshu.crq.service;

import com.jnshu.crq.model.Reply;

import java.util.List;

/**
 * @author crq131290
 * @title ReplyService
 * @description todo
 * @date 2019/08/26
 */
public interface ReplyService {
    int addReply(Reply reply) throws Exception;

    Boolean deleteReplyById(int id) throws Exception;

    Boolean updateReply(Reply reply) throws Exception;

    Reply getReplyById(int id) throws Exception;

    List<Reply> getReplyList(int artId) throws Exception;
}
