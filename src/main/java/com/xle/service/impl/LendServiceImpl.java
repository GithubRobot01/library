package com.xle.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xle.entity.PageResult;
import com.xle.entity.QueryPageBean;
import com.xle.mapper.BookMapper;
import com.xle.mapper.LendMapper;
import com.xle.pojo.Lend;
import com.xle.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LendServiceImpl implements LendService {

    @Autowired
    LendMapper lendMapper;

    @Autowired
    BookMapper bookMapper;

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage,pageSize);
        Page<Lend> page = lendMapper.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(Lend lend) {
        //将借去图书的数量减去
        bookMapper.subtract(lend); //如果数量不够就会抛出异常,借书失败
        //添加借书记录
        lendMapper.add(lend);
    }

    @Override
    public void backBook(Lend lend) {
        //将归还图书数量加上
        bookMapper.addMount(lend);
        //添加归还日期
        lendMapper.backBook(lend);
    }

}
