package com.crq.spring.jdbc.Dao;

import com.crq.bean.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl2 extends JdbcDaoSupport implements UserDao {
    //继承JdbcDaoSupport，就无需jdbctemplate
    @Override
    public User getUserById(int id) {
        String sql = "select * from userbean where id = ?";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u =new User();
                u.setAge(resultSet.getString("age"));
                u.setId(resultSet.getString("id"));
                u.setQq(resultSet.getString("qq"));
                u.setName(resultSet.getString("name"));
                return u;
            }
        },id);
    }
}
