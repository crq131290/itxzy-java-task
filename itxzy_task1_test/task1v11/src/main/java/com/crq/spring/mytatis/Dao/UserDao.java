package com.crq.spring.mytatis.Dao;

import com.crq.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDao")
public interface UserDao {
     User getUserById(int id);
     void addUser(User u);
     void bulkAddUser(List<User> users);

}
