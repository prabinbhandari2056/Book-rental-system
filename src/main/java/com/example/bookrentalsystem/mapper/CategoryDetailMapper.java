package com.example.bookrentalsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryDetailMapper {
    @Select("select * from tbl_category where \"category_id\"= #{categoryId}")
    Object findCategoryById(Integer categoryId);
}
