package com.jnshu.crq.utils;
//import org.apache.ibatis.io.Resources;

import java.io.FileReader;
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
//            in = Resources.getResourceAsReader("c3p0.properties");
            in = new FileReader("src\\main\\resources\\c3p0.properties");
            System.out.println(in);
            prop.load(in);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        url = prop.getProperty("jdbcUrl");
        pwd = prop.getProperty("password");
        user = prop.getProperty("user");
        driver = prop.getProperty("driverClass");
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
