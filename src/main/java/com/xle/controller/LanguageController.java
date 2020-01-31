package com.xle.controller;

import com.xle.constant.MessageConstant;
import com.xle.entity.Result;
import com.xle.pojo.Language;
import com.xle.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @RequestMapping("/findAll")
    public Result findAll(){
        List<Language> languages=languageService.findAll();
        if (languages.size()<=0||languages==null){
            return new Result(false,MessageConstant.QUERY_LANGUAGE_FAIL);
        }
        return new Result(true, MessageConstant.QUERY_LANGUAGE_SUCCESS,languages);
    }
}
