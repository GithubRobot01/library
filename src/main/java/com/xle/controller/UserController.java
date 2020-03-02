package com.xle.controller;

import com.xle.constant.MessageConstant;
import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;
import com.xle.entity.Result;
import com.xle.pojo.User;
import com.xle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
        if (loginUser!=null&&"0".equals(loginUser.getType())){
            //管理员登录
            return "redirect:/pages/main.html";
        }else if (loginUser!=null&&"1".equals(loginUser.getType())){
            //学生登录
            return "redirect:/pages/main.html";
        }
        return "redirect:/login.html";
    }


    //获取当前用户的用户名
    @RequestMapping("/getName")
    @ResponseBody
    public Result getName(){
        if(loginUser != null){
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS,loginUser);
        }
        return new Result(false, MessageConstant.GET_USERNAME_FAIL);
    }

    //根据条件分页查询数据信息
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findpage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = userService.findPage(queryPageBean);
        return pageResult;
    }

    //添加学生用户
    @RequestMapping("/add")
    @ResponseBody
    public Result addUser(@RequestBody User user){
        //设置用户为学生类型
        user.setType("1");
        System.out.println(user);
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_USER_FAIL);
        }
        return new Result(true,MessageConstant.ADD_USER_SUCCESS);
    }

    //根据用户名查询用户信息
    @RequestMapping("/findByUsername")
    @ResponseBody
    public Result findByUsername(String username){
        User user=userService.findByUsername(username);
        if (user==null){
            return new Result(false,MessageConstant.QUERY_USER_FAIL);
        }
        return new Result(true,MessageConstant.QUERY_USER_SUCCESS,user);
    }

    //更新用户信息
    @RequestMapping("/update")
    @ResponseBody
    public Result updateUser(@RequestBody User user){
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.UPDATE_USER_FAIL);
        }
        return new Result(true,MessageConstant.UPDATE_USER_SUCCESS,user);
    }

    //更新用户信息
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteUser(String username){
        try {
            userService.deleteUser(username);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_USER_FAIL);
        }
        return new Result(true,MessageConstant.DELETE_USER_SUCCESS);
    }


}
