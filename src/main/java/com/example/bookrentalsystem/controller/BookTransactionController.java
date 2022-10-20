package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.model.Member;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.BookTransactionDetailRequestPojo;
import com.example.bookrentalsystem.pojo.MemberDetailRequestPojo;
import com.example.bookrentalsystem.service.BookTransactionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bookrent/booktransaction")
public class BookTransactionController extends ApiResponse {
    private final BookTransactionService bookTransactionService;

    public BookTransactionController(BookTransactionService bookTransactionService) {
        this.bookTransactionService = bookTransactionService;
    }


    @GetMapping("getbooktransaction")
    public List<BookTransaction> getBookTransaction() {
        return bookTransactionService.getBookTransaction();
    }

    @PostMapping("savebooktransaction")
    public ApiResponse saveBookTransactionDetails(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo){
        bookTransactionService.saveBookTransactionDetails(bookTransactionDetailRequestPojo);
        return success("Book Transaction  Successfully", null);
    }

    @PostMapping("rentabook")
    public ApiResponse rentBookTransaction(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo){
        bookTransactionService.addNewTransaction(bookTransactionDetailRequestPojo);
        return success("Book Transaction Saved Successfully", null);
    }
    @PostMapping("returnabook")
    public ApiResponse returnABookTransaction(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo){
        bookTransactionService.addReturnTransaction(bookTransactionDetailRequestPojo);
        return success("Book Transaction Return Successfully", null);
    }

    @GetMapping("getbooktransaction/{memberId}")
    public ApiResponse getBookTransactionByMemberId(@PathVariable(name = "memberId") Integer memberId) {
        return success("Member data fetched successuflly", bookTransactionService.getBookTransactionById(memberId));
    }
}
