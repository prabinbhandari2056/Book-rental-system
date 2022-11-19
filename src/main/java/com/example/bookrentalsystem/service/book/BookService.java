package com.example.bookrentalsystem.service.book;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.book.BookDetailRequestPojo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface BookService {
    Object getBookById(Integer bookId);
    void saveBookDetails(BookDetailRequestPojo bookDetailRequestPojo) throws Exception;
    public List<Book> getBook();

    @Transactional
    void updateBookStock(BookDetailRequestPojo bookDetailRequestPojo);

    void deleteBookById(Integer bookId) throws AppException;
}
