package com.jnshu.crq.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * desc : 新增用户请求
 * create_user : cheng
 * create_date : 2019/1/23 11:34
 */
public class AddUserRequest {
    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String userName;
    /**
     * 年龄
     */
    @Min(value = 0, message = "用户年龄最小为0")
    private int age;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
