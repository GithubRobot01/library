package com.xle.service;

import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;
import com.xle.pojo.User;

public interface UserService {
    //用户登录
    User login(User user);

    //根据条件进行分页查找用户信息
    PageResult findPage(QueryPageBean queryPageBean);

    //添加用户信息
    void addUser(User user);

    //根据用户名查询用户信息
    User findByUsername(String username);

    //更新用户信息
    void updateUser(User user);

    //删除用户信息
    void deleteUser(String username);
}
