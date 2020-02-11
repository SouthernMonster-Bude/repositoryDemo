package o.h.j.m.dao;

import o.h.j.m.pojo.User;

import java.util.List;

public interface IUserDao {
    User getUserByUserName(String userName);

    List<String> getRolesByUserName(String userName);
}
