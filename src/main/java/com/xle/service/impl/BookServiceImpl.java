package com.xle.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;
import com.xle.mapper.BookMapper;
import com.xle.pojo.Book;
import com.xle.pojo.PopularBook;
import com.xle.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookMapper.findByIsbn(isbn);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(String isbn) {
        bookMapper.deleteBook(isbn);
    }

    @Override
    public List<Integer> findBookCountByMonths(List<String> months) {
        List<Integer> bookCount=new ArrayList<>();
        for (String month : months) {
            String date=month+"-31"; //2020-03-31
            Integer count=bookMapper.findBookCountBeroreDate(date);
            bookCount.add(count);
        }
        return bookCount;
    }

    @Override
    public Map<String, Object> popularBookByWeek() {
        Map<String, Object> map= new HashMap<>();
        List<PopularBook> list=bookMapper.popularBookByWeek();
        List<String> name=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for (PopularBook popularBook : list) {
            name.add(popularBook.getName());
            count.add(popularBook.getCount());
        }
        map.put("name",name);
        map.put("count",count);
        return map;
    }

    @Override
    public Map<String, Object> popularBookByMonth() {
        Map<String, Object> map= new HashMap<>();
        List<PopularBook> list=bookMapper.popularBookByMonth();
        List<String> name=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for (PopularBook popularBook : list) {
            name.add(popularBook.getName());
            count.add(popularBook.getCount());
        }
        map.put("name",name);
        map.put("count",count);
        return map;
    }
}
