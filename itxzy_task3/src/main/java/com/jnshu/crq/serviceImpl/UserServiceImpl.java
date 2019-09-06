package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.UserMapper;
import com.jnshu.crq.model.User;
import com.jnshu.crq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByName(String name) throws Exception {
        List<User> list = userMapper.getUserByName(name);
        return list;
    }

    @Override
    public User getUserLogin(String name, String password) throws Exception {
        User user = userMapper.getUserLogin(name,password);
        return user;
    }

    @Override
    public int addUser(User user) throws Exception {
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public int deleteUserById(int id) throws Exception {
        userMapper.delete(id);
        return id;
    }

    @Override
    public int updateUser(User user) throws Exception {
        userMapper.update(user);
        return user.getId();
    }

    @Override
    public User getUserById(int id) throws Exception {
        return userMapper.getUser(id);
    }

    @Override
    public List<User> getUserList() throws Exception {
        List<User> list = new ArrayList<>();
        list = userMapper.getUserList();
        return list;
    }
}
