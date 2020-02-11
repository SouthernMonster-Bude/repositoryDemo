package o.h.j.m.dao.impl;

import o.h.j.m.dao.IUserDao;
import o.h.j.m.pojo.User;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
@Component
public class UserDao implements IUserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public User getUserByUserName(String userName) {
        String sql ="Select * from users where username=?";
        List<User> list = jdbcTemplate.query(sql, new String[]{userName}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<String> getRolesByUserName(String userName) {
        String sql = "select role_name from user_roles where username = ?";
        return jdbcTemplate.query(sql, new String[]{userName}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("role_name");
            }
        });
    }
}
