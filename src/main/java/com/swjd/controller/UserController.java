package com.swjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swjd.bean.User;
import com.swjd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    //去到登录页面
    @RequestMapping("/toLogin1")
    public String toLogin(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "login";
    }
    //做登录
    @RequestMapping("/doLogin1")
    public String doLogin(User user, Model model, HttpSession session){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("uname",user.getuName()).or().eq("password",user.getPassword());
        User u=userService.getOne(queryWrapper);
        if (u!=null){
            if (u.getFlag().equals("1")){
                session.setAttribute("name",u.getuName());

                return "forward:/tomain1";
            }else {
                model.addAttribute("error","账号被冻结！");
                model.addAttribute("user",user);
                return "login";
            }
        }else {
            model.addAttribute("error","账号或密码错误！");
            model.addAttribute("user",user);
            return "login";
        }
    }
    //提供一个方法，能够访问我的淘宝页面
    @RequestMapping("/toMy1")
    public String toMy(){
        return "mytaobao";
    }
    //提供一个方法，能够访问我的购物车
    @RequestMapping("/toCar1")
    public String tocar(){
        return "shoppingcar";
    }
    //提供一个方法，直接访问主页面
    @RequestMapping("/tomain1")
    public String tomain(Model model,HttpSession session){
        String state="";
        if(session.getAttribute("name")!=null){
            state= (String) session.getAttribute("name");
            System.out.println(state);
        }else{
            state="亲，请先登录";
        }
        model.addAttribute("state",state);

        return "main";
    }

}
