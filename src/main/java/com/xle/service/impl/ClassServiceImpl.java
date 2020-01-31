package com.xle.service.impl;

import com.xle.mapper.ClassMapper;
import com.xle.mapper.LanguageMapper;
import com.xle.pojo.Class;
import com.xle.pojo.Language;
import com.xle.service.ClassService;
import com.xle.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;
    @Override
    public List<Class> findAll() {
        return classMapper.findAll();
    }
}
