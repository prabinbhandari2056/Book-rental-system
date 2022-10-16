package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.BookTransactionDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookTransactionDetailMapper {
    @Select("select * from tbl_book_transaction where \"book_transaction_id\" =#{bookTransactionId}")
    BookTransactionDetailResponsePojo getBookTransactionById(Integer bookTransactionId);
}
