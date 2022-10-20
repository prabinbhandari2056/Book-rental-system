package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.BookDetailRequestPojo;
import com.example.bookrentalsystem.pojo.BookTransactionDetailRequestPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDetailMapper {
    @Select("select * from tbl_book where \"book_id\"=#{bookId}")
    BookDetailRequestPojo getBookById(Integer bookId);

    @Select("select stock from tbl_book where \"book_id\"=#{bookId}")
    Integer getStockById(Integer bookId);


}
