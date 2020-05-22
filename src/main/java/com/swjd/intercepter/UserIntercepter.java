package com.swjd.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //放行的条件
        //1.不需要登录之后访问的页面
        String uri=request.getRequestURI();//获取请求的地址
        if(uri.indexOf("login")>=0||uri.indexOf("Login")>=0){
            return true;//放行
        }
        if(uri.indexOf("main")>=0){
            return true;//放行
        }

        //2.需要登录之后才可以访问(我已经登录过了)
        HttpSession session=request.getSession();
        if( session.getAttribute("name")!=null){
            return true;//放行
        }
        request.getRequestDispatcher("/toLogin").forward(request,response);
        return false;
    }
}
