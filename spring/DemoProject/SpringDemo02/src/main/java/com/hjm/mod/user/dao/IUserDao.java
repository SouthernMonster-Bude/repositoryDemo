package com.hjm.mod.user.dao;

import com.hjm.mod.pojo.User;

public interface IUserDao {
    void save();
    void save2();
    User query(String id);
}
