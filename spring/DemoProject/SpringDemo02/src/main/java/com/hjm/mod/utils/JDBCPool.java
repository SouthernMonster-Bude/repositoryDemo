package com.hjm.mod.utils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPool {
    DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public void excuteInsertSql(String sql){
        try {
            Connection con = null;
            Statement stmt = null;
            // 连接对象
            con = dataSource.getConnection();
            // 执行命令对象
            stmt =  con.createStatement();
            // 执行
            stmt.execute(sql);
            // 关闭
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
