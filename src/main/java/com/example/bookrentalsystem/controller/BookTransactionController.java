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
@RequestMapping("bookrental/booktransaction")
public class BookTransactionController extends BaseController {
    private final BookTransactionService bookTransactionService;

    public BookTransactionController(BookTransactionService bookTransactionService) {
        this.bookTransactionService = bookTransactionService;
    }


    @GetMapping()
    public ApiResponse getBookTransaction() {
        return success(get("data.get","Book Transaction"), bookTransactionService.getBookTransaction());
    }


    @PostMapping("add-book-transaction")
    public ApiResponse rentBookTransaction(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) throws AppException {
        bookTransactionService.addNewTransaction(bookTransactionDetailRequestPojo);
        if (bookTransactionDetailRequestPojo.getRentType().toString().equalsIgnoreCase("RENT"))
         return success(get("book.rent"), null);
        else
            return  success(get("book.return"),null);
    }
//    @PostMapping("return-book")
//    public ApiResponse returnABookTransaction(@RequestBody @Valid BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo){
//        bookTransactionService.addReturnTransaction(bookTransactionDetailRequestPojo);
//        return success(get("book.return"),null);
//    }

    @GetMapping("/{memberid}")
    public ApiResponse getBookTransactionByMemberId(@PathVariable(name = "memberid") Integer memberId) {
        return success(get("data.get","Book Transaction"), bookTransactionService.getBookTransactionByMemberId(memberId));
    }

    @DeleteMapping("/{booktransactionid}")
    public ApiResponse deleteBookTransactionById(@PathVariable(name = "booktransactionid") Integer bookTransactionId) throws AppException {
        bookTransactionService.deleteBookTransactionById(bookTransactionId);
        return success(get("data.delete"," Book transaction"),null);
    }
}
