package com.xle.pojo;

import lombok.Data;

import java.io.Serializable;


@Data
public class Book implements Serializable {

    private String name;//书名
    private String author;//作者
    private String publish;//出版社
    private String isbn;//书号
    private String language_name;//语言
    private String class_name;//类别
    private Integer pressmark;//书架号
    private String introduction; //介绍
    private int state;//书籍状态(1上架,0下架)
    private int number;//剩余数量

}
