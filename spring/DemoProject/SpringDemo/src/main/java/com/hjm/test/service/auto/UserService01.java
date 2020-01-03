package com.hjm.test.service.auto;

import com.hjm.test.dao.UserDao;
import com.hjm.test.dto.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userSvc")
public class UserService01 {

    @Resource(name = "userDao")
    UserDao userDao;
    User user;
    List<String> userList;
    UserService01(){System.out.println("new UserService01() "+this+" created!");}
    UserService01(User user){
        System.out.println("UserService01(User "+user+") "+this+" created!");
        this.user = user;
    }
    UserService01(User user, List<String> userList){
        System.out.println("UserService01(User "+user+",List<String> userList) "+this+" created!");
        this.user = user;
        this.userList = userList;
    }
    public double random(){
        return userDao.random();
    }
}
