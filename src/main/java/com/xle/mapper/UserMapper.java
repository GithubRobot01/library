package com.xle.mapper;


import com.xle.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * from user where username=#{username} and password=#{password} ")
    User login(User user);


}
