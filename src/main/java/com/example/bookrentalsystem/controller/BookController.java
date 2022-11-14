package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.pojo.api.ApiResponse;
import com.example.bookrentalsystem.pojo.api.BaseController;
import com.example.bookrentalsystem.pojo.book.BookDetailRequestPojo;
import com.example.bookrentalsystem.service.book.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This controller returns book details and save book details using for data.
 */
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("bookrental/book")
public class BookController extends BaseController {
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
    public ApiResponse saveBookDetails(@ModelAttribute @Valid  BookDetailRequestPojo bookDetailRequestPojo) throws Exception {
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

