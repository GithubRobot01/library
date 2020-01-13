package com.xle.service;

import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;

public interface BookService {
    /**
     * 根据条件分页查找书籍信息
     * @param queryPageBean 查询条件
     * @return 页面信息
     */
    PageResult findPage(QueryPageBean queryPageBean);
}
