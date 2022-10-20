package com.example.bookrentalsystem.repository;

import com.example.bookrentalsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Modifying
    @Query(value = "update  tbl_book set stock_count =stock_count-1 where \"book_id\"=?1",nativeQuery = true)
    void updateBookRent(Integer bookId);
    @Modifying
    @Query(value = "update  tbl_book set stock_count =stock_count+1 where \"book_id\"=?1",nativeQuery = true)
    void updateBookReturn(Integer bookId);

    @Modifying
    @Query(value = "update  tbl_book set stock_count =stock_count + ?2  where \"book_id\"=?1",nativeQuery = true)
    void updateBookStock(Integer bookId, Integer stockCount);

//    @Modifying
//    @Query(value = "update  tbl_book set stock_count =stock_count+1 where \"book_id\"=?1",nativeQuery = true)
//    void updateBookReturn(Integer bookId);


//    Optional<Object> findBookById(Integer bookId);
////    @Query(value = "update  tbl_book set stock_count =stock_count-1 where \"book_id\"=?1",nativeQuery = true)
////    Optional<Book> updateBookReturn(Integer bookId);
}
