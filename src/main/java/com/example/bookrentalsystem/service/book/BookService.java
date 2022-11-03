package com.example.bookrentalsystem.service.book;

import com.example.bookrentalsystem.globalException.CustomExceptionHandler;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.BookDetailRequestPojo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface BookService {
    Object getBookById(Integer bookId);
    void saveBookDetails(BookDetailRequestPojo bookDetailRequestPojo) throws CustomExceptionHandler;
    public List<Book> getBook();

    @Transactional
    void updateBookStock(BookDetailRequestPojo bookDetailRequestPojo);
}
