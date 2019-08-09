package com.crq.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  数据库连接工具类
 *
 * */

public class DBUtil {//静态代码块
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {

//        driver = "com.mysql.jdbc.Driver";
//        url = "jdbc:mysql://localhost:3306/itxzy";
//        user = "crq131290";
//        password = "root";


        Properties prop = new Properties();
        Reader in ;
        try {
            in = new FileReader("src\\main\\java\\config.properties"); //反斜杠是转义符，所以需要双斜线
            prop.load(in);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver = prop.getProperty("driver");
        url = prop.getProperty("url");
        user = prop.getProperty("user");
        password =prop.getProperty("password");

    }

    public static Connection open(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
