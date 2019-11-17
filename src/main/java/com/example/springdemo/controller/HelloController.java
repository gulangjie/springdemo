package com.example.springdemo.controller;

import com.example.springdemo.pojo.JsonResult;
import com.example.springdemo.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello worle";
    }

    @RequestMapping(value = "/getResource")
    public JsonResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return JsonResult.ok(bean);
    }
}
