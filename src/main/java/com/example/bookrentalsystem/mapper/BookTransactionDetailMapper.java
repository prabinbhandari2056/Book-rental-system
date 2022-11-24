package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.book.BookDetailResponsePojo;
import com.example.bookrentalsystem.pojo.bookTransaction.BookTransactionDetailResponsePojo;
import com.example.bookrentalsystem.pojo.member.MemberDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface BookTransactionDetailMapper {

    @Select("select case when rent_status<>'RENT' or rent_status is null then true else false end from tbl_book_transaction where \"member_id\"=#{memberId} order by book_transaction_id desc LIMIT 1 ")
    Boolean getRentStatus(Integer memberId);
    @Select("select case when rent_status='RENT'  then true else false end from tbl_book_transaction where \"member_id\"=#{memberId} and \"book_id\"=#{bookId} order by book_transaction_id desc LIMIT 1 ")
    Boolean getReturnStatus(Integer memberId,Integer bookId);


    @Select("select stock_count from tbl_book where \"book_id\" = #{bookId}")
    Integer getStockCount(Integer bookId);


}
