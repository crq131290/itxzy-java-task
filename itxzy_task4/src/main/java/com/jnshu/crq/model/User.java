package com.jnshu.crq.model;

public class User {
//public class User implements Comparable{
    private long id;
    private String name;
    private String position;
    private int salary;
    private String synopsis;
    private String img;
    private long createAt;
    private long updateAt;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", position='" + position + '\'' + ", salary=" + salary + ", synopsis='" + synopsis + '\'' + ", img='" + img + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

//    按salary排序
//    @Override
//    public int compareTo(Object o) {
//        User user = (User) o;
//        return salary>user.salary?1:(salary==user.salary?0:-1);
//    }
}
