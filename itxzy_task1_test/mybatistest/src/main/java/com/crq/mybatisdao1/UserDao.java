package com.crq.mybatisdao1;

import com.crq.bean.User;

/**
 * @Title:UserDao
 * @ProjectName:mybatistest
 * @Description:Todo
 * @author crq
 * @date 2019/03/26 21:44
 * */
public interface UserDao {
    /**
     * 根据id查询
     * @param id
     * @return User
     * */
    public User getUserById(int id);
}
