package com.xle.controller;

import com.xle.constant.MessageConstant;
import com.xle.entity.Result;
import com.xle.pojo.User;
import com.xle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    User loginUser;

    //用户登录
    @RequestMapping("/login")
    public String login(User user){
        loginUser = userService.login(user);
        if (loginUser!=null){
            return "redirect:/pages/main.html";
        }
        return "redirect:/login.html";
    }


    //获取当前用户的用户名
    @RequestMapping("/getName")
    @ResponseBody
    public Result getName(){
        if(loginUser != null){
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS,loginUser.getName());
        }
        return new Result(false, MessageConstant.GET_USERNAME_FAIL);
    }

}
