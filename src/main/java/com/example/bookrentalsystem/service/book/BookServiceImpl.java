package com.example.bookrentalsystem.service.book;

import com.example.bookrentalsystem.globalException.CustomExceptionHandler;
import com.example.bookrentalsystem.mapper.BookDetailMapper;
import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.model.Category;
import com.example.bookrentalsystem.pojo.BookDetailRequestPojo;
import com.example.bookrentalsystem.repository.AuthorRepository;
import com.example.bookrentalsystem.repository.BookRepository;
import com.example.bookrentalsystem.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{

    private  final BookRepository bookRepository;

    private final ObjectMapper objectMapper;

    private  final BookDetailMapper bookDetailMapper;

    private final CategoryRepository categoryRepository;

    private  final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, ObjectMapper objectMapper, BookDetailMapper bookDetailMapper, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.objectMapper = objectMapper;
        this.bookDetailMapper = bookDetailMapper;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Object getBookById(Integer bookId) {
        BookDetailRequestPojo bookDetailRequestPojo1=bookDetailMapper.getBookById(bookId);
        return bookDetailRequestPojo1;
    }

    @Override
    public void saveBookDetails(BookDetailRequestPojo bookDetailRequestPojo) throws CustomExceptionHandler {
        Book book = null;
        if (bookDetailRequestPojo.getBookId()!= null)
            book = bookRepository.findById(bookDetailRequestPojo.getBookId()).orElse(new Book());
        book = objectMapper.convertValue(bookDetailRequestPojo, Book.class);

        Category category=categoryRepository.findById(bookDetailRequestPojo.getCategoryId()).orElseThrow(()->new CustomExceptionHandler("Category does not exist by category id"));
        book.setCategory(category);
        List<Author> authors=authorRepository.findAllById(bookDetailRequestPojo.getAuthorId());
        if (authors.size()!=bookDetailRequestPojo.getAuthorId().size())
            throw new CustomExceptionHandler("Authors does not exist");
        book.setAuthor(authors);
        bookRepository.save(book);
}



    @Override
    public List<Book> getBook() {
                return bookRepository.findAll();
    }
    @Transactional
    @Override
    public void updateBookStock(BookDetailRequestPojo bookDetailRequestPojo) {
        Category category=categoryRepository.findById(bookDetailRequestPojo.getCategoryId()).orElseThrow(()->new RuntimeException("Category does not exist by category id"));
        List<Author> authors=authorRepository.findAllById(bookDetailRequestPojo.getAuthorId());
        bookRepository.updateBookStock(bookDetailRequestPojo.getBookId(),bookDetailRequestPojo.getStockCount());
    }
}
