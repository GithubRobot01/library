package com.xle.controller;

import com.xle.constant.MessageConstant;
import com.xle.entity.Result;
import com.xle.pojo.Class;
import com.xle.pojo.Language;
import com.xle.service.ClassService;
import com.xle.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping("/findAll")
    public Result findAll(){
        List<Class> classes=classService.findAll();
        if (classes.size()<=0||classes==null){
            return new Result(false,MessageConstant.QUERY_CLASS_FAIL);
        }
        return new Result(true, MessageConstant.QUERY_CLASS_SUCCESS,classes);
    }
}
