package com.crq.jdbc;

import java.sql.*;

/*
 * JDBC的编程步骤
 * 加载数据库驱动（jar文件） -----通过不同的数据库驱动来连接不同的数据库，即跨数据库特性
 * 获取数据库连接
 * 创建语句
 * 执行语句
 * 遍历结果集
 * 关闭数据库连接
 *
 * */
public class JdbcDemo1 {
    public static void main(String[] args){
//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itxzy","crq131290","root"); //建立数据库连接
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Connection conn = DBUtil.open();

        String sql = "select id,name,email from CusttomerTbl ";//查询 sql语句
        try {
            Statement stmt = conn.createStatement();//Statement
            ResultSet rs = stmt.executeQuery(sql);//执行查询，返回一个结果集，带指针的数组
            //rs  结果集
            while (rs.next()){
                int id =  rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                System.out.println(id+","+name+","+email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            if(conn !=null) {
//                try {
//                    conn.close();//关闭数据库连接
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
            DBUtil.close(conn);
        }
    }
}
