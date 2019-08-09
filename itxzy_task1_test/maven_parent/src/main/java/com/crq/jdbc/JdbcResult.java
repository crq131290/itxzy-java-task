package com.crq.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * ResultSet 结果集
 * 1.用于获取SQL语句的查询结果
 * 2.结果集包含了SQL语句的查询结果数据
 * 3.调用语句的executeQuery方法返回结果集对象
 * 4.ResultSet常用方法
 * next() 判断结果集中是否还有数据
 *
 *  getXXX 获取结果集的数据项
 *       索引or列名称
 *
 * */
public class JdbcResult {
    public static void main(String[] args){
        query();
    }

    static List<User> query(){
        Connection conn = DBUtil.open();
        String sql = "select id,name from UserTbl";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<User> list = new ArrayList<User>();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                //System.out.println(id+","+name);
                User u = new User();
                u.setId(id);
                u.setName(name);

                list.add(u);
            }
            System.out.println(list);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return  null;

    }
}


