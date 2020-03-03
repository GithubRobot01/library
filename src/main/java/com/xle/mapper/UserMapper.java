package com.xle.mapper;


import com.github.pagehelper.Page;
import com.xle.pojo.Book;
import com.xle.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface UserMapper {

    //用户登录
    User login(User user);

    //根据条件查询用户信息
    Page<User> selectByCondition(String queryString);

    //添加用户信息
    void addUser(User user);

    //根据用户名查询用户信息
    User findByUsername(String username);

    //更新用户信息
    void updateUser(User user);

    //删除用户信息
    void deleteUser(String username);

    //修改密码
    void changePassword(Map<String, String> map);
}
