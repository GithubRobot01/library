package com.xle.service;

import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;
import com.xle.pojo.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    /**
     * 根据条件分页查找书籍信息
     * @param queryPageBean 查询条件
     * @return 页面信息
     */
    PageResult findPage(QueryPageBean queryPageBean);

    //添加图书信息
    void addBook(Book book);

    //根据isbn查询图书信息
    Book findByIsbn(String isbn);

    //编辑(更新)图书信息
    void updateBook(Book book);

    //删除图书信息
    void deleteBook(String isbn);

    //根据月份查询图书数量
    List<Integer> findBookCountByMonths(List<String> months);

    //获取本周热门图书信息
    Map<String, Object> popularBookByWeek();

    //获取本月热门图书信息
    Map<String, Object> popularBookByMonth();
}
