package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.globalException.CustomExceptionHandler;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.BookDetailRequestPojo;
import com.example.bookrentalsystem.service.book.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This controller returns book details and save book details.
 */
@RestController
@RequestMapping("bookrental/book")
public class BookController extends ApiResponse{
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping()
    public ApiResponse getBook() {
        return success(get("data.get","Book"),bookService.getBook());
    }


    /**
     * This function saves the book details
     * @param bookDetailRequestPojo
     * @return saveBookDetails
     */
    @PostMapping()
    public ApiResponse saveBookDetails(@RequestBody @Valid BookDetailRequestPojo bookDetailRequestPojo) throws CustomExceptionHandler {
        bookService.saveBookDetails(bookDetailRequestPojo);
        return success(get("data.save","Book"), null);
    }

    @GetMapping("/{bookid}")
    public ApiResponse getBookById(@PathVariable(name = "bookid") Integer bookId) {
        return success(get("data.get","Book"), bookService.getBookById(bookId));
    }
    @PostMapping("update-stock")
    public ApiResponse updateBookStock(@RequestBody @Valid BookDetailRequestPojo bookDetailRequestPojo){
        bookService.updateBookStock(bookDetailRequestPojo);
        return success(get("data.update.stock","Book"), null);
    }
}

