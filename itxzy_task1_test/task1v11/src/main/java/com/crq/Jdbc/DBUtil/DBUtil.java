package com.crq.Jdbc.DBUtil;

//import org.apache.ibatis.io.Resources;

import org.apache.ibatis.io.Resources;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static String url;
    private static String pwd;
    private static String user;
    private static String driver;
    static {
        Properties prop = new Properties();
        Reader in;
//        Resources resources = new
        try {
            in = Resources.getResourceAsReader("config/jdbc/jdbc.properties");
//            in = new FileReader("src\\main\\resources\\config\\spring.jdbc.properties");
            System.out.println(in);
            prop.load(in);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        url = prop.getProperty("jdbc.url");
        pwd = prop.getProperty("jdbc.pwd");
        user = prop.getProperty("jdbc.user");
        driver = prop.getProperty("jdbc.driver");
    }

    public static Connection open(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection con){
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
