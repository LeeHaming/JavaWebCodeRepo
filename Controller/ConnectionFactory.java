package com.WeChat.leeham;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private String driver;
    private String dburl;
    private String user;
    private String password;
    
    private Connection conn;
    
    private ConnectionFactory(){
        
        driver = "com.mysql.jdbc.Driver";
        dburl = "jdbc:mysql://localhost/wechat?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
        user = "root";
        password = "asdfghjkl456";
    }
    
    private static class FactoryHolder{
        private static final ConnectionFactory instance = new ConnectionFactory();
    }
    
    public static ConnectionFactory getInstance(){
        
        return FactoryHolder.instance;
    }

    public Connection makeConnection(){
        // 数据库连接
        try {
        	System.out.println("connection start!!!");
            Class.forName(driver);
            
            conn = DriverManager.getConnection(dburl, user, password);
            System.out.println("connection success!!!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	System.out.println("connection failed!!!");
            e.printStackTrace();
        }
        return conn;
    }
}
