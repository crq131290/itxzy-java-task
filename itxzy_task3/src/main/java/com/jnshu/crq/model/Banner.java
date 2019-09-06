package com.jnshu.crq.model;

/**
 * @author crq131290
 * @title Banner
 * @description todo
 * @date 2019/08/26
 * */
public class Banner {
    private int id;
    private int artId;
    private String imgUrl;
    private String title;
    private Long createAt;
    private Long updateAt;

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

    @Override
    public String toString() {
        return "Banner{" + "id=" + id + ", artId=" + artId + ", imgUrl='" + imgUrl + '\'' + ", title='" + title + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
