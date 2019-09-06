package com.jnshu.crq.model;

/**
 * @author crq131290
 * @title 留言
 * @description todo
 * @date 2019/08/26
 */
public class Reply {
    private int id;
    private String content;
    private int replyId;
    private int artId;
    private Long createAt;
    private Long updateAt;
    private User user;
    private User other;

    @Override
    public String toString() {
        return "Reply{" + "id=" + id + ", content='" + content + '\'' + ", replyId=" + replyId + ", artId=" + artId + ", createAt=" + createAt + ", updateAt=" + updateAt + ", user=" + user + ", other=" + other + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getOther() {
        return other;
    }

    public void setOther(User other) {
        this.other = other;
    }
}
