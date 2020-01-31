package com.xle.mapper;

import com.xle.pojo.Class;
import com.xle.pojo.Language;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//书籍类型相关操作
public interface ClassMapper {

    @Select("select class_id id,class_name name from class_info")
    List<Class> findAll();
}
