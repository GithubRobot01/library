package com.xle.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
public class Book implements Serializable {

    private String name;//书名
    private String author;//作者
    private String publish;//出版社
    private String isbn;//书号
    private String language_name;//语言
    private String language_id;//语言
    private String class_name;//类别
    private String class_id;//类别
    private Integer pressmark;//书架号
    private String introduction; //介绍
    private String state;//书籍状态(1上架,0下架)
    private int number;//剩余数量
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date storage_date; //图书入库时间

}
