package com.hjm.mod.sys.dao;

import com.hjm.mod.pojo.User;
import com.hjm.mod.user.dao.IUserDao;
import com.hjm.mod.user.service.IUserService;
import com.hjm.mod.utils.JDBCConnection;
import com.hjm.mod.utils.JDBCPool;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {



    @Test
    public void testTransactionDemo(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring/jdbc.conf.xml");
        IUserService userService = (IUserService)ac.getBean("userService");
        userService.save();
    }
    @Test
    public void testQueryDemo(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring/jdbc.conf.xml");
        IUserDao userDao = (IUserDao)ac.getBean("userDao");
//        userDao.save();
        User user =  userDao.query("5545642");
        System.out.println(user);
    }
    @Test
    public void testDBPoolDemo(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring/jdbc.conf.xml");
        IUserDao userDao = (IUserDao)ac.getBean("userDao");
//        userDao.save();
        userDao.save2();
    }
    @Test
    public void testUtilsDemo(){
        try {
            String sql = "insert into tbl_demo(id,name) values('5545646','test06');";
            Connection con = JDBCConnection.getConnection();
            Statement stmt = con.createStatement();
            // 执行
            stmt.execute(sql);
            JDBCConnection.release(con,stmt,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDemo(){
        try {
            String sql = "insert into tbl_demo(id,name) values('5545645','test05');";
            Connection con = null;
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            // 连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdemo", "root", "root");
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
