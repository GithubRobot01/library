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

    //根据条件分页查询数据信息
    @RequestMapping("/findPage")
    public PageResult findpage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = bookService.findPage(queryPageBean);
        return pageResult;
    }

    //添加图书信息
    @RequestMapping("/add")
    public Result addBook(@RequestBody Book book){
        try {
            bookService.addBook(book);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_BOOK_FAIL);
        }
        return new Result(true, MessageConstant.ADD_BOOK_SUCCESS);
    }

    //通过isbn查找图书信息,用于数据回显
    @RequestMapping("/findByIsbn")
    public Result findByIsbn(String isbn){
        Book book=bookService.findByIsbn(isbn);
        if (book==null){
            return new Result(false,MessageConstant.QUERY_BOOK_FAIL);
        }
        return new Result(true,MessageConstant.QUERY_BOOK_SUCCESS,book);
    }

    //更新(编辑)图书信息
    @RequestMapping("/update")
    public Result updateBook(@RequestBody Book book){
        try{
            bookService.updateBook(book);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.UPDATE_BOOK_FAIL);
        }
        return new Result(true,MessageConstant.UPDATE_BOOK_SUCCESS);
    }

    //删除图书信息
    @RequestMapping("/delete")
    public Result deleteBook(String isbn){
        try {
            bookService.deleteBook(isbn);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_BOOK_FAIL);
        }
        return new Result(true,MessageConstant.DELETE_BOOK_SUCCESS);
    }

}
