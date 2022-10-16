package com.example.bookrentalsystem.service;

import com.example.bookrentalsystem.mapper.BookDetailMapper;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.model.Category;
import com.example.bookrentalsystem.pojo.BookDetailRequestPojo;
import com.example.bookrentalsystem.repository.BookRepository;
import com.example.bookrentalsystem.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{

    private  final BookRepository bookRepository;

    private final BookDetailRequestPojo bookDetailRequestPojo;

    private final ObjectMapper objectMapper;

    private  final BookDetailMapper bookDetailMapper;

    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, BookDetailRequestPojo bookDetailRequestPojo, ObjectMapper objectMapper, BookDetailMapper bookDetailMapper, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.bookDetailRequestPojo = bookDetailRequestPojo;
        this.objectMapper = objectMapper;
        this.bookDetailMapper = bookDetailMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Object getBookById(Integer bookId) {
        BookDetailRequestPojo bookDetailRequestPojo1=bookDetailMapper.getBookById(bookId);
        return bookDetailRequestPojo1;
    }

    @Override
    public void saveBookDetails(BookDetailRequestPojo bookDetailRequestPojo) {
        Book book = null;
        if (bookDetailRequestPojo.getBookId()!= null)
            book = bookRepository.findById(bookDetailRequestPojo.getBookId()).orElse(new Book());
        book = objectMapper.convertValue(bookDetailRequestPojo, Book.class);
        Category category=categoryRepository.findById(bookDetailRequestPojo.getCategoryId()).orElseThrow(()->new RuntimeException("Category does not exist by category id"));
        book.setCategory(category);
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBook() {
                return bookRepository.findAll();
    }

}
