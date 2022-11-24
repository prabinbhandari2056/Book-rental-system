package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.book.BookDetailResponsePojo;
import com.example.bookrentalsystem.pojo.bookTransaction.BookTransactionDetailResponsePojo;
import com.example.bookrentalsystem.pojo.member.MemberDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BookTransactionDetailMapper {

    @Select("select case when rent_status<>'RENT' or rent_status is null then true else false end from tbl_book_transaction where \"member_id\"=#{memberId} order by book_transaction_id desc LIMIT 1 ")
    Boolean getRentStatus(Integer memberId);
    @Select("select case when rent_status='RENT'  then true else false end from tbl_book_transaction where \"member_id\"=#{memberId} and \"book_id\"=#{bookId} order by book_transaction_id desc LIMIT 1 ")
    Boolean getReturnStatus(Integer memberId,Integer bookId);


    @Select("select stock_count from tbl_book where \"book_id\" = #{bookId}")
    Integer getStockCount(Integer bookId);

//    @Query(value = "select tbt.book_transaction_id,tbt.rent_status,tbt.code,tbt.from_date,tbt.to_date,tbt.return_date, tm.member_id ,tm.name,tb.book_id,tb.book_name from tbl_book_transaction tbt inner join tbl_book tb on tb.book_id=tbt.book_id inner join tbl_member tm on tm.member_id = tbt.member_id where tbt.member_id=?1",nativeQuery = true)
//    @Select("select tbt.book_transaction_id,tbt.rent_status,tbt.code,tbt.from_date,tbt.to_date,tbt.return_date, tm.member_id ,tm.name,tb.book_id,tb.book_name from tbl_book_transaction tbt inner join tbl_book tb on tb.book_id=tbt.book_id inner join tbl_member tm on tm.member_id = tbt.member_id where tbt.member_id=#{memberId}")
    @Select("select tbt.book_transaction_id as bookTransactionId,tbt.rent_status as rentStatus,tbt.code as code,tbt.from_date as fromDate,tbt.to_date as toDate,tbt.return_date as returnDate, tm.member_id as memberId,tm.name as memberName,tb.book_id as bookId,tb.book_name as bookName from tbl_book_transaction tbt inner join tbl_book tb on tb.book_id=tbt.book_id inner join tbl_member tm on tm.member_id = tbt.member_id where tbt.member_id=#{memberId}")
    List<BookTransactionDetailResponsePojo> getBookTransactionByMemberId(Integer memberId);


}
