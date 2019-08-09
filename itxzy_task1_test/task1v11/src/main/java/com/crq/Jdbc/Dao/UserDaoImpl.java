package com.crq.Jdbc.Dao;

import com.crq.Jdbc.DBUtil.DBUtil;
import com.crq.bean.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserById(int id) {
        Connection con = DBUtil.open();
        String sql = "select * from userbean where id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if( rs.next()){
                User u = new User();
                u.setId(rs.getString("id"));
                u.setName(rs.getString("name"));
                u.setQq(rs.getString("qq"));
                u.setAge(rs.getString("age"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con);
        }
        return null;
    }
}
