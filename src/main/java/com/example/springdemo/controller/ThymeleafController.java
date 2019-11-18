package com.example.springdemo.controller;

import com.example.springdemo.pojo.Resource;
import com.example.springdemo.pojo.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap map){
//        map.addAttribute("resource",resource);
        map.addAttribute("name","thymeleaf-imooc");
        return "thymeleaf/index";
    }

    @RequestMapping("/center")
    public String center(){
        return "thymeleaf/center/center";
    }

    @RequestMapping("/test")
    public String test(ModelMap map){
        User u = new User();
        u.setName("manage");
        u.setAge(16);
        u.setPassword("123456");
        u.setBirthday(new Date());
        u.setDesc("<font color='green'><b>hello imooc</b></font>");
        map.addAttribute("user",u);


        User u1 = new User();
        u1.setName("imooc");
        u1.setAge(16);
        u1.setPassword("123456");
        u1.setBirthday(new Date());
        List<User> userList = Lists.newArrayList();
        userList.add(u);
        userList.add(u1);
        map.addAttribute("ulist",userList);

        return "thymeleaf/test";
    }

    @PostMapping("postform")
    public String postform(User u){

        System.out.println(u.getName());

        return "redirect:/th/test";
    }

}
