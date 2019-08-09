package com.crq.jdbctempl.Dao;

import com.crq.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

//public class UserDaoImpl implements UserDao{
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{ //继承JdbcDaoSupport，就不需要手动创建jdbctem
//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Override
    public User getUserById(String id) {
        String sql = "select * from userbean where id = ?";
        return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {//采用父类super.getJdbcTemplate()获取jdbctem
//        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                System.out.println(i);
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setQq(rs.getString("qq"));
                return user;
            }
        },id);
    }
}
