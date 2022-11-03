package com.example.bookrentalsystem.mapper;

import com.example.bookrentalsystem.pojo.BookDetailResponsePojo;
import com.example.bookrentalsystem.pojo.BookTransactionDetailResponsePojo;
import com.example.bookrentalsystem.pojo.MemberDetailResponsePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface BookTransactionDetailMapper {
    @Select("select * from tbl_book_transaction where \"book_transaction_id\" =#{bookTransactionId}")
    BookTransactionDetailResponsePojo getBookTransactionById(Integer bookTransactionId);

    @Select("select * from tbl_book where \"book_id\" =#{bookId}")
    Optional<BookDetailResponsePojo> getBookId(Integer bookId);

    @Select("select *  from tbl_book_transaction where \"member_id\"=#{memberId}")
    Optional<MemberDetailResponsePojo> findMember(Integer memberId);

//    @Select("select case when rent_status='RENT' then true else false end from tbl_book_transaction where \"member_id\"=#{memberId}")
    @Select("select case when rent_status<>'RENT' or rent_status is null then true else false end from tbl_book_transaction where \"member_id\"=#{memberId}")
    Boolean getRentStatus(Integer memberId);

//    @Select("select rent_status from  tbl_book_transaction where \"member_id\"=#{memberId}")
    @Select("select case when rent_status='Rent' then true else false end from tbl_book_transaction where \"member_id\"=#{memberId}")
    String getRentStatus2(Integer memberId);

    @Select("select stock_count from tbl_book where \"book_id\" = #{bookId}")
    Integer getStockCount(Integer bookId);

    @Select("select case when rent_status <>'RENT' or rent_status is null then true else false end from tbl_book_transaction where \"member_id\"=#{memberId}")
//    @Select("select case when rent_status='Rent' then false else true end from tbl_book_transaction where \"member_id\"=#{memberId}")
    String getRentStat(Integer memberId);
}
