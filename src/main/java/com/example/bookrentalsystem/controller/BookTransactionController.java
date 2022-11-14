package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.pojo.api.ApiResponse;
import com.example.bookrentalsystem.pojo.api.BaseController;
import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.pojo.bookTransaction.BookTransactionDetailRequestPojo;
import com.example.bookrentalsystem.service.booktransaction.BookTransactionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("bookrent/booktransaction")
public class BookTransactionController extends BaseController {
    private final BookTransactionService bookTransactionService;

    public BookTransactionController(BookTransactionService bookTransactionService) {
        this.bookTransactionService = bookTransactionService;
    }


    @GetMapping()
    public ApiResponse getBookTransaction() {
        return success(get("data.get","Book Transaction"), bookTransactionService.getBookTransaction());
    }

    @PostMapping()
    public ApiResponse saveBookTransactionDetails(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) throws AppException {
        bookTransactionService.saveBookTransactionDetails(bookTransactionDetailRequestPojo);
        return success(get("data.save","Book Transaction"), null);
    }

    @PostMapping("rent-book")
    public ApiResponse rentBookTransaction(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) throws AppException {
        bookTransactionService.addNewTransaction(bookTransactionDetailRequestPojo);
        return success(get("book.rent"), null);
    }
    @PostMapping("return-book")
    public ApiResponse returnABookTransaction(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo){
        bookTransactionService.addReturnTransaction(bookTransactionDetailRequestPojo);
        return success(get("book.return"),null);
    }

    @GetMapping("/{memberid}")
    public ApiResponse getBookTransactionByMemberId(@PathVariable(name = "memberid") Integer memberId) {
        return success(get("data.get","Book Transaction"), bookTransactionService.getBookTransactionById(memberId));
    }
}
