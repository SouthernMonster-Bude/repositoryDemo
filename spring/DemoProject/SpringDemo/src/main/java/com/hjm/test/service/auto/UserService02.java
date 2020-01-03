package com.hjm.test.service.auto;

import com.hjm.test.dao.UserDao;
import com.hjm.test.dto.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService002")
public class UserService02 {

    @Resource(name = "userDao")
    UserDao userDao;
    User user;
    List<String> userList;
    UserService02(){System.out.println("new UserService02() "+this+" created!");}
    UserService02(User user){
        System.out.println("UserService02(User "+user+") "+this+" created!");
        this.user = user;
    }
    UserService02(User user, List<String> userList){
        System.out.println("UserService02(User "+user+",List<String> userList) "+this+" created!");
        this.user = user;
        this.userList = userList;
    }
    public double random(){
        return userDao.random();
    }
}
