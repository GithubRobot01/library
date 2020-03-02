package com.xle.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 */
@Data
public class User implements Serializable{
    private String sid; //学号
    private String name; //姓名
    private String sex; //性别
    private String major; //专业
    private String clazz; //班级(避免与关键字class冲突)
    private String username; //用户名
    private String password; //密码
    private String type; //用户类型(0表示管理员,1表示学生)

}
