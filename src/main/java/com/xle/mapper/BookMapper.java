package com.xle.mapper;

import com.github.pagehelper.Page;
import com.xle.pojo.Book;

public interface BookMapper {
    //根据条件查询图书信息
    Page<Book> selectByCondition(String queryString);

    //添加图书信息
    void addBook(Book book);

    //查找图书信息
    Book findByIsbn(String isbn);

    //更新图书信息
    void updateBook(Book book);

    //删除图书信息
    void deleteBook(String isbn);
}
