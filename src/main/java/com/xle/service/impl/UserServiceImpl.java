package com.xle.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;
import com.xle.mapper.UserMapper;
import com.xle.pojo.User;
import com.xle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage,pageSize);
        Page<User> page = userMapper.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }

    @Override
    public void changePassword(Map<String, String> map) {
        userMapper.changePassword(map);
    }
}
