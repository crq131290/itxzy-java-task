package com.jnshu.crq.service;

import com.jnshu.crq.model.User;

import java.util.List;

/**
 * @author crq131290
 * @title userService
 * @description todo
 * @date 2019/08/26
 */
public interface UserService {
    int addUser(User user) throws Exception;

    int deleteUserById(int id) throws Exception;

    int updateUser(User user) throws Exception;

    User getUserById(int id) throws Exception;

    List<User> getUserByName(String name) throws Exception;

    User getUserLogin(String name,String password) throws Exception;

    List<User> getUserList() throws Exception;
}
