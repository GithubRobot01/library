package com.xle.mapper;

import com.github.pagehelper.Page;
import com.xle.pojo.Lend;

public interface LendMapper {
    //根据条件查询图书借阅信息
    Page<Lend> selectByCondition(String queryString);

    //添加图书借阅信息
    void add(Lend lend);

    //归还图书
    void backBook(Lend lend);

    //续借图书
    void renewBook(Lend lend);
}
