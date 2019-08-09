package com.crq.spring.jdbc.Dao;

import com.crq.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserById(int id) {
        String sql = "select * from userbean where id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getString("id"));
                u.setName(resultSet.getString("name"));
                u.setQq(resultSet.getString("qq"));
                u.setAge(resultSet.getString("age"));
                return u;
            }
        },id);
    }
}
