package com.crq.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * statement 是SQL语句的描述 ，使用它可以操作各种SQL语句，包括DDL（数据定义，如创建表）DML(CURD)和DCL等
 * 1.使用Statement语句创建表
 * 2.插入数据
 * 3.更新数据
 * 4.删除数据
 * 5.查询数据
 *
 * 其实Statemment语句只是执行了我们传入的sql语句，而且是定死的sql语句
 * */
public class JdbcStatement {
    public static void main(String[] args){
//        createTable();
//        insert();
//        update();
//        delete();
        query2();
    }

    static void createTable(){
        Connection conn = DBUtil.open();//连
        String sql = "create table UserTbl(id int primary key auto_increment,name varchar(20))";

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);//执行sql语句
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    static void insert(){
        Connection conn = DBUtil.open();//连
        String sql = "insert into UserTbl(name) values('tom2')";

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);//执行sql语句
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    static void update(){
        Connection conn = DBUtil.open();//连
        String sql = "update UserTbl set name='big Tom' where id = 2";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    static void delete(){
        Connection conn = DBUtil.open();//连
        String sql = "delete from UserTbl where id = 2";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    static void query(){
        Connection conn = DBUtil.open();//连
        String sql = "select id,name from UserTbl";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println(id+","+name);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    static List<User> query2(){
        Connection conn = DBUtil.open();//连
        String sql = "select id,name from UserTbl";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<User> list = new ArrayList<User>();

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                //System.out.println(id+","+name);
                User u = new User();
                u.setId(id);
                u.setName(name);
                list.add(u);
            }
            System.out.println(list);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return null;
    }
}

