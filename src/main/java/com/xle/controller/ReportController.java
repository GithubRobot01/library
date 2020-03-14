package com.xle.controller;

import com.xle.constant.MessageConstant;
import com.xle.entity.Result;
import com.xle.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 报表操作
 */

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    BookService bookService;

    //图书数量折线图
    @RequestMapping("/getBookReport")
    public Result getBookReport(){
        //格式化日期
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Map<String,Object> map=new HashMap<>();
        List<String> months=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        //计算过去6个月
        calendar.add(Calendar.MONTH,-6); //将当前时间向前推6个月
        for (int i = 0; i < 6; i++) {
            calendar.add(Calendar.MONTH,1);
            Date date=calendar.getTime();
            months.add(sdf.format(date));
        }
        map.put("months",months);
        try{
            List<Integer> bookCount=bookService.findBookCountByMonths(months);
            map.put("bookCount",bookCount);
        }catch (Exception e){
            return new Result(false, MessageConstant.GET_BOOK_NUMBER_REPORT_FAIL);
        }
        return new Result(true, MessageConstant.GET_BOOK_NUMBER_REPORT_SUCCESS,map);
    }

    //本周热门图书
    @RequestMapping("/popularBookByWeek")
    public Result popularBookByWeek(){
        Map<String,Object> map=new HashMap<>();
        try {
            map=bookService.popularBookByWeek();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.GET_POPULAR_BOOK_OF_WEEK_FAIL);
        }
        return new Result(true,MessageConstant.GET_POPULAR_BOOK_OF_WEEK_SUCCESS,map);
    }

    //本月热门图书
    @RequestMapping("/popularBookByMonth")
    public Result popularBookByMonth(){
        Map<String,Object> map=new HashMap<>();
        try {
            map=bookService.popularBookByMonth();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.GET_POPULAR_BOOK_OF_MONTH_FAIL);
        }
        return new Result(true,MessageConstant.GET_POPULAR_BOOK_OF_MONTH_SUCCESS,map);
    }

}
