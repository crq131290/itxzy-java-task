package com.crq.mybatis;

import com.crq.bean.User;

//@Select("select * from userbean where id = #{id}")
public interface UserDao {
    public User getUserById(int id);
}
