package com.example.springdemo.exception;

import com.example.springdemo.pojo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class IMoocExceptionHandler {

    public static final String IMOOC_ERROR_VIEW = "error";

//    @ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest request,
//                               HttpServletResponse response, Exception e)throws Exception{
//        e.printStackTrace();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", request.getRequestURI());
//        mav.setViewName(IMOOC_ERROR_VIEW);
//        return mav;
//    }
    @ExceptionHandler(Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception e)throws Exception{
        e.printStackTrace();

        if(isAjax(request)){
            return JsonResult.errorException(e.getMessage());
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURI());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
        }
    }

    /**
     * 判断请求是否ajax请求
     *
     * @param request
     * @return
     */
    private boolean isAjax(HttpServletRequest request) {
        return request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
