package com.xle.controller;

import com.xle.constant.MessageConstant;
import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;
import com.xle.entity.Result;
import com.xle.pojo.Book;
import com.xle.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/findPage")
    public PageResult findpage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = bookService.findPage(queryPageBean);
        return pageResult;
    }

    @RequestMapping("/add")
    public Result addBook(@RequestBody Book book){
        try {
            bookService.addBook(book);
        }catch (Exception e){
            return new Result(false,MessageConstant.ADD_BOOK_FAIL);
        }
        return new Result(true, MessageConstant.ADD_BOOK_SUCCESS);
    }
}
