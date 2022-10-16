package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.AuthorDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface AuthorDetailMapper {
    @Select("select * from tbl_author where \"author_id\"= #{authorId}")
    AuthorDetailResponsePojo getAuthorById(Integer authorId);
}
