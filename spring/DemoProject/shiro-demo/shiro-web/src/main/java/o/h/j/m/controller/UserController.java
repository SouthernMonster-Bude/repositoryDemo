package o.h.j.m.controller;

import o.h.j.m.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
//    @RequestMapping(value = "/sublogin")
    @RequestMapping(value = "/sublogin",method= RequestMethod.POST)
    @ResponseBody
    public String sublogin(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            token.setRememberMe(user.isRememberMe());
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return "login success";
    }
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){

        return "hello";
    }
    @RequiresRoles("user")
    @RequestMapping(value = "/testRolesUser")
    @ResponseBody
    public String testRolesUser(){

        return "testRoles-user success";
    }
//    @RequiresRoles("admin")
    @RequestMapping(value = "/testRolesAdmin")
    @ResponseBody
    public String testRolesAdmin(){

        return "testRoles-admin success";
    }
    @RequestMapping(value = "/testPerms")
    @ResponseBody
    public String testPerms(){
        return "testPerms success";
    }

}
