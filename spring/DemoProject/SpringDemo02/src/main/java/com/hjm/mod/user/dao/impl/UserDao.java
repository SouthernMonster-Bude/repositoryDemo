package com.hjm.mod.user.dao.impl;

import com.hjm.mod.pojo.User;
import com.hjm.mod.user.dao.IUserDao;
import com.hjm.mod.utils.JDBCPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao implements IUserDao {
    @Autowired
    JDBCPool jdbcPool;
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void save() {
        jdbcPool.excuteInsertSql("insert into tbl_demo(id,name) values('7788995','UserDao-save');");
        System.out.println("DB:保存用户");
    }
    public void save2() {
        jdbcTemplate.execute("insert into tbl_demo(id,name) values('7788996','UserDao-save2');");
        System.out.println("DB:保存用户2");
    }
    public User query(String id) {
        String sql = "select * from tbl_demo where id=?";

        List<User> queryList = jdbcTemplate.query(sql, new RowMapper<User>() {
            //将每行记录封装成User对象
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setId(resultSet.getString("id"));
                return user;
            }
        },id);
        System.out.println(queryList);
        return queryList.get(0);
    }

}