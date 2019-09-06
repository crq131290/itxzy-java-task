package com.jnshu.crq.mapper;

import com.jnshu.crq.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author crq131290
 * @title userDao
 * @description todo
 * @date 2019/08/26
 * */
public interface UserMapper {
    void insert(User user) throws Exception;

    void delete(int id) throws Exception;

    void update(User user) throws Exception;

    User getUser(int id) throws Exception;

    List<User> getUserByName(String name) throws Exception;

    User getUserLogin(@Param("name") String name, @Param("password") String password) throws Exception;

    List<User> getUserList() throws Exception;
}
