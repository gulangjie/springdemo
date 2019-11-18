package com.example.springdemo.exception;

import com.example.springdemo.pojo.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

    //@ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest request,
                                          Exception e) throws Exception{
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
