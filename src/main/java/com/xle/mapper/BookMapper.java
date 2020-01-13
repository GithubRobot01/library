package com.xle.mapper;

import com.github.pagehelper.Page;
import com.xle.pojo.Book;

public interface BookMapper {
    Page<Book> selectByCondition(String queryString);
}
