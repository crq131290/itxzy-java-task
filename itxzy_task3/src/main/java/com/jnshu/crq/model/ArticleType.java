package com.jnshu.crq.model;

/**
 * @author crq131290
 * @title 作品类别
 * @description todo
 * @date 2019/08/26
 * */
public class ArticleType {
    private int id;
    private String name;
    private Long createAt;
    private Long updateAt;
    private int artClass;

    @Override
    public String toString() {
        return "ArticleType{" + "id=" + id + ", name='" + name + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + ", artClass=" + artClass + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getArtClass() {
        return artClass;
    }

    public void setArtClass(int artClass) {
        this.artClass = artClass;
    }
}
