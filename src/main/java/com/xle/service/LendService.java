package com.xle.service;

import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;
import com.xle.pojo.Lend;

public interface LendService {
    /**
     * 根据条件分页查找借阅
     * @param queryPageBean 查询条件
     * @return 页面信息
     */
    PageResult findPage(QueryPageBean queryPageBean);

    //添加图书借阅记录
    void add(Lend lend);

    //归还图书
    void backBook(Lend lend);
}
