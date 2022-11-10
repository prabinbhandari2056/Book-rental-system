package com.example.bookrentalsystem.repository;

import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.pojo.bookTransaction.BookTransactionDetailRequestPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookTransactionRepository extends JpaRepository<BookTransaction,Integer> {
    BookTransactionDetailRequestPojo bookTransactiondetailRequestPojo = new BookTransactionDetailRequestPojo();
    List<BookTransaction> findAll();


    @Modifying
     @Query(value = "update  tbl_book_transaction set rent_status ='RETURN' where \"book_id\"=?1 and\"member_id\"=?2 and rent_status='RENT'",nativeQuery = true)
    void updateBookReturnTransaction(Integer bookId, Integer memberId);

//    @Select("select * from tbl_book_transaction where \"member_id\"=#{memberId} and \"book_id\"=#{book_id} and rent_status='RENT'")
//    Optional<Member> findMemberById(Integer memberId,Integer bookId);
//
//    @Select("select * from tbl_book_transaction where \"book_id\"=#{bookId}")
//    Optional<Object> finBookById(Integer bookId);

//    @Modifying
//    @Query(value = "update  tbl_book_transaction set rent_status ='RETURN' where \"book_id\"=?1 and\"member_id\"=?2 and rent_status='RENT'",nativeQuery = true)
//    void updateBookTransactionReturn(Integer bookId, Integer memberId);


//    BookTransaction findBookTransactionByBookAndMemberId(Integer bookTransactionId, @NotNull Integer memberId);
//
//    @Select("select book_id from tbl_book_transaction where \"member_id\"=#{memberId} and \"book_id\"=#{book_id} and rent_status='RENT'")
//    Optional<Book> findBookById(Integer bookId,Integer memberId);

//    BookTransaction findBookTransactionBy()
}
