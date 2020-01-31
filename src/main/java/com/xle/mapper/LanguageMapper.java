package com.xle.mapper;

import com.xle.pojo.Language;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//书籍语言相关操作
public interface LanguageMapper {

    @Select("select language_id id,language_name name from language_info")
    List<Language> findAll();
}
