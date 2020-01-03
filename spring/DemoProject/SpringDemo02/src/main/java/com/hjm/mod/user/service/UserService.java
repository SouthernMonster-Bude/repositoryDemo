package com.hjm.mod.user.service;

import com.hjm.mod.user.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService{
    @Autowired
    IUserDao userDao;
    @Override
    public void save() {
        userDao.save();
        int i = 1 / 0;
        userDao.save2();
    }
}
