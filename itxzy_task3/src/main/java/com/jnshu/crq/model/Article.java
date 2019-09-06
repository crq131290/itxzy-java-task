package com.jnshu.crq.model;
/**
 * @author crq131290
 * @title 作品详情
 * @description Todo
 * @date 2019/08/06
 * */
public class Article {
    private int id;
    private Long  createAt;//创作时间
    private Long  updateAt;//创作时间
    private String  name;
    private String  artClass;
    private int  type;
    private int  userId;
    private Long  time;
    private String  img;//作品简图
    private String  synopsis;

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", createAt=" + createAt + ", updateAt=" + updateAt + ", name='" + name + '\'' + ", artClass='" + artClass + '\'' + ", type=" + type + ", userId=" + userId + ", time=" + time + ", img='" + img + '\'' + ", synopsis='" + synopsis + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtClass() {
        return artClass;
    }

    public void setArtClass(String artClass) {
        this.artClass = artClass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
