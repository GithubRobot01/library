package com.xle.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;
import com.xle.mapper.BookMapper;
import com.xle.pojo.Book;
import com.xle.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage,pageSize);
        Page<Book> page = bookMapper.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
