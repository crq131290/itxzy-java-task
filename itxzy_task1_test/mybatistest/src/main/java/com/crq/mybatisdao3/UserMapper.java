package com.crq.mybatisdao3;

import com.crq.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * @param id
     * @return User
     * */
    @Select("select * from UserTbl where id = #{uid}")
    public User getUserById(int id);

    @Insert("insert into UserTbl(name,email) values(#{name},#{email})")
    public void addUser(User u);

    @Select("select * from UserTbl")
    public List<User> queryUsers();
}
