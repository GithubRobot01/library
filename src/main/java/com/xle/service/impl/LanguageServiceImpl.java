package com.xle.service.impl;

import com.xle.mapper.LanguageMapper;
import com.xle.pojo.Language;
import com.xle.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageMapper languageMapper;
    @Override
    public List<Language> findAll() {
        return languageMapper.findAll();
    }
}
