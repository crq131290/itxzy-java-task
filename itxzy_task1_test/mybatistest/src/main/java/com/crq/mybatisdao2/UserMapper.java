package com.crq.mybatisdao2;

import com.crq.bean.User;

public interface UserMapper {
    /**
     * @param id
     * @return User
     * */

    public User getUserById(int id);
//    public List<User> getUserById(int id);
}
