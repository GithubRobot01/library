package com.xle.controller;

import com.xle.constant.MessageConstant;
import com.xle.entity.QueryPageBean;
import com.xle.entity.Result;
import com.xle.pojo.Lend;
import com.xle.service.LendService;
import com.xle.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Calendar;

@RestController
@RequestMapping("/lend")
public class LendController {
    @Autowired
    LendService lendService;

    //根据条件分页查询图书借阅信息
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = lendService.findPage(queryPageBean);
        return pageResult;
    }

    //添加借阅记录
    @RequestMapping("/add")
    public Result add(@RequestBody Lend lend){
        Calendar c=Calendar.getInstance();
        //获取当天日期
        Date lend_Date=new Date(c.getTimeInMillis());
        lend.setLend_date(lend_Date);
        //当天日期向后推30天就是应还书日期
        c.add(Calendar.DATE,30);
        Date due_Date=new Date(c.getTimeInMillis());
        lend.setDue_date(due_Date);

        try {
            lendService.add(lend);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_LEND_FAIL);
        }
        return new Result(true,MessageConstant.ADD_LEND_SUCCESS);
    }

    //归还图书
    @RequestMapping("/back")
    public Result backBook(@RequestBody Lend lend){
        Calendar c=Calendar.getInstance();
        //获取当天日期
        Date back_date=new Date(c.getTimeInMillis());
        lend.setBack_date(back_date);
        try {
            lendService.backBook(lend);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.BACK_BOOK_FAIL);
        }
        return new Result(true,MessageConstant.BACK_BOOK_SUCCESS);
    }

    //续借图书
    @RequestMapping("/renew")
    public Result renewBook(@RequestBody Lend lend){
        //取出应还时间
        java.util.Date due_date = lend.getDue_date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(due_date);
        //向后推30天
        calendar.add(Calendar.DATE,30);
        Date due_Date=new Date(calendar.getTimeInMillis());
        lend.setDue_date(due_Date);
        try {
            lendService.renewBook(lend);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.RENEW_BOOK_FAIL);
        }
        return new Result(true,MessageConstant.RENEW_BOOK_SUCCESS);
    }

}
