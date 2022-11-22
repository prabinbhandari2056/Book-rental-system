package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.book.BookDetailRequestPojo;
import com.example.bookrentalsystem.pojo.book.BookDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Mapper
public interface BookDetailMapper {
    @Select("select * from tbl_book where \"book_id\"=#{bookId}")
    BookDetailResponsePojo getBookById(Integer bookId);



    @Select("select book_name from tbl_book where \"book_id\"=#{bookId}")
    String getBookName(Integer bookId);


    @Select("select stock_count from tbl_book where \"book_id\"=#{bookId}")
    Integer getBookCount(Integer bookId);

    @Select("select book_id as bookId, book_name as bookName from tbl_book")
    List<Book> getBookIdName();
}
