package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.UserMapper;
import com.jnshu.crq.model.User;
import com.jnshu.crq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
