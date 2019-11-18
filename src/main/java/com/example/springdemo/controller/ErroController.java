package com.example.springdemo.controller;

import com.example.springdemo.pojo.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/err")
public class ErroController {

    @RequestMapping("error")
    public String error(){

        int i = 1/0;

        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror(){

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping(value = "/getAjaxerror",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getAjaxerror(){
        int i = 1/0;
        return JsonResult.ok();
    }
}
