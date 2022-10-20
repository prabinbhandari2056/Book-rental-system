package com.example.bookrentalsystem.service;

import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.BookDetailRequestPojo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface BookService {
    Object getBookById(Integer bookId);
    void saveBookDetails(BookDetailRequestPojo bookDetailRequestPojo);
    public List<Book> getBook();

    @Transactional
    void updateBookStock(BookDetailRequestPojo bookDetailRequestPojo);
}
