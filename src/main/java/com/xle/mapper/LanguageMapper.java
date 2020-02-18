package com.xle.mapper;

import com.xle.pojo.Language;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//书籍语言相关操作
public interface LanguageMapper {

    @Select("select language_id id,language_name name from language_info")
    List<Language> findAll();

    @Select("SELECT l.language_id id,l.language_name name from book_info b,language_info l where b.language_id=l.language_id and isbn=#{isbn}")
    Language findLanguageByIsbn(String isbn);
}
