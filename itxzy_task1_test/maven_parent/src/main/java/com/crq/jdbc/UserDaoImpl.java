package com.crq.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/***
 * User javabean
 * UserDao
 * UserDaoImpl
 *
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void add(User u) {
        String sql = "insert into UserTbl(name,email)values(?,?)";
        Connection conn = DBUtil.open();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,u.getName());
            pstmt.setString(2,u.getEmail());

            pstmt.executeUpdate();

        } catch (SQLException e) {
             e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }

    @Override
    public void update(User u) {
        String sql = "update UserTbl set name = ?,email = ? where id = ?";
        Connection conn = DBUtil.open();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,u.getName());
            pstmt.setString(2,u.getEmail());
            pstmt.setInt(3,u.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from UserTbl where id = ?";
        Connection conn = DBUtil.open();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }

    @Override
    public User getUserById(int id) {
        String sql = "select id,name,email from UserTbl where id = ?";
        Connection conn = DBUtil.open();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String name = rs.getString(2);
                String email = rs.getString(3);
                User u = new User();
                u.setId(id);
                u.setName(name);
                u.setEmail(email);
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return null;
    }

    @Override
    public List<User> query() {
        String sql = "select id,name,email from UserTbl";
        Connection conn = DBUtil.open();
        try {
            Statement stmt = conn.createStatement();//静态seatement
            ResultSet rs = stmt.executeQuery(sql);
            List<User> list = new ArrayList<User>();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                User u = new User();
                u.setId(id);
                u.setName(name);
                u.setEmail(email);
                list.add(u);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return null;
    }
}
