package com.example.springdemo.controller;

import com.example.springdemo.pojo.JsonResult;
import com.example.springdemo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController                   //RestController = @Controller + @ResponseBody
@RequestMapping(value="/user")
public class UserController {

    @RequestMapping(value="/getUser")
    public User getUser(){
        User user = new User();
        user.setName("imooc");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("imooc");
        return user;
    }

    @RequestMapping(value="/getUserJson")
    public JsonResult getUserJson(){
        User user = new User();
        user.setName("imooc");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("imooc");
        return JsonResult.ok(user);
    }
}
