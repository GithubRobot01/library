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
    private String name;
    private String username;
    private String password;

}
