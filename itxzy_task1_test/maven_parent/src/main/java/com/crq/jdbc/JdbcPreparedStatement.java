package com.crq.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * PreparedStatement
 * 继承Statement
 * Statement只能操作静态sql语句
 * PreparedStatement动态操作sql语句
 * 使用占位符 ？ ，来预生成SQL语句，从而达到动态生成SQL语句
 *
 *
 * */
public class JdbcPreparedStatement {
    public static void main(String[] args){
        //insert("rose","rose@gmail");
//        User u = new User();
//        u.setName("王花花");
//        u.setEmail("whh@gmail");
//        insert(u);

//        User u = new User();
//        u.setId(1);
//        u.setName("王花花");
//        u.setEmail("whh@gmail");
//        update(u);

        //del(3);
        User u = query(3);
        if(u!=null)
            System.out.println(u);
    }
    static void insert(String name,String email){
        Connection conn = DBUtil.open();
        String sql = "insert into UserTbl(name,email) values(?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            int x = pstmt.executeUpdate();
            System.out.println(x);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    static void insert(User u){
        Connection conn = DBUtil.open();
        String sql = "insert into UserTbl(name,email) values(?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,u.getName());
            pstmt.setString(2,u.getEmail());
            int x = pstmt.executeUpdate();
            System.out.println(x);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    static void update(User u){
        Connection conn = DBUtil.open();
        String sql = "update UserTbl set name=?,email=? where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,u.getName());
            pstmt.setString(2,u.getEmail());
            pstmt.setInt(3,u.getId());
            int x = pstmt.executeUpdate();
            System.out.println(x);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    static void del(int id){
        Connection conn = DBUtil.open();
        String sql = "delete from UserTbl where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            int x = pstmt.executeUpdate();
            System.out.println(x);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    static User query(int id){
        Connection conn = DBUtil.open();
        String sql = "select id,name,email from UserTbl where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){
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
        }finally {
            DBUtil.close(conn);
        }
        return null;
    }
}
