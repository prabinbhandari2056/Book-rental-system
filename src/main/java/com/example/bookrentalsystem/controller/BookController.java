package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.BookDetailRequestPojo;
import com.example.bookrentalsystem.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bookrental/book")
public class BookController extends ApiResponse{
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("getbook")
    public List<Book> getBook() {
        return bookService.getBook();
    }

    @PostMapping("savebook")
    public ApiResponse saveBookDetails(@RequestBody @Valid BookDetailRequestPojo bookDetailRequestPojo){
        bookService.saveBookDetails(bookDetailRequestPojo);
        return success("Book Saved Successfully", null);
    }

    @GetMapping("getbook/{bookId}")
    public ApiResponse getBookById(@PathVariable(name = "bookId") Integer bookId) {
        return success("Book data fetched successuflly", bookService.getBookById(bookId));
    }
}
