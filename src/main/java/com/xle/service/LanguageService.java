package com.xle.service;

import com.xle.pojo.Language;

import java.util.List;

public interface LanguageService {
    List<Language> findAll();

    Language findLanguageByIsbn(String isbn);
}
