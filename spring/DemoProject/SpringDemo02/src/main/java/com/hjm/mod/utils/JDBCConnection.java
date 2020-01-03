package com.hjm.mod.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCConnection {
    /*
     * 连接数据库的driver，url，username，password通过配置文件来配置，可以增加灵活性
     * 当我们需要切换数据库的时候，只需要在配置文件中改以上的信息即可
     *
     * */

    private static String  driver = null;
    private static String  url = null;
    private static String  username = null;
    private static String password = null;

    static {
        try {
            //获取配置文件的读入流
            InputStream inputStream = JDBCConnection.class.getClassLoader().getResourceAsStream("conf/db/db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            //获取配置文件的信息
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            //加载驱动类
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
