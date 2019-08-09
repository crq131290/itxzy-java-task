package com.crq.jdbc;

import java.sql.*;

/*
* CallableStatement
* extend PrepareStatement
* 提供了调用存储过程的能力
* 其实指我们把mysql操作数据库sql语句封装到mysql当中，这里可以理解为一个函数，
* 在mysql当中去调用这个函数时，就会执行相应的sql语句
* 而这个函数就是一个存储过程
* 而CallableStatement就是能调用这个存储过程的一个借口一样的东西
* */
public class JdbcCallableStatement {
    public static void main(String[] args){
        //query();
//       insert();
        query2();
    }


    static void query(){
        Connection  conn = DBUtil.open();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call all_users()}");
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id+","+name+","+email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }

    }

    static void insert(){
        Connection  conn = DBUtil.open();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insert_user(?,?)}");

            cstmt.setString("myname","tom33");
            cstmt.setString("myemail","tom33@email");
            int x = cstmt.executeUpdate();
            System.out.println(x);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }

    }

    static void query2(){
        Connection  conn = DBUtil.open();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call getnamebyid(?,?)}");

            cstmt.setInt("cid",5);
            cstmt.registerOutParameter("return_name", Types.CHAR);
            cstmt.execute();//执行

            String name = cstmt.getString("return_name");

            System.out.println(name);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }

    }
}
