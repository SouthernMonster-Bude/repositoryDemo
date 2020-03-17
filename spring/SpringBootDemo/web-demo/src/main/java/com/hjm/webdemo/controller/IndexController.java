package com.hjm.webdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping()
public class IndexController {
    @RequestMapping("/index")
    public String index(Model m, HttpServletRequest httpServletRequest){
//        String path = httpServletRequest.getContextPath();
//        String scheme = httpServletRequest.getScheme();
//        String serverName = httpServletRequest.getServerName();
//        int port = httpServletRequest.getServerPort();
//        String base = scheme + "://" + serverName + ":" + port + path;
//        m.addAttribute("base",base);
        return "page/index";
    }

    @RequestMapping("/goLogin")
    public String login(Model m) {
        return "page/login";
    }





    @RequestMapping("/test1")
    public String test(Model m) {
//        m.addAttribute("name", "后终结");
        return "test";
    }
}
