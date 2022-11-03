package com.example.bookrentalsystem.service.booktransaction;


import com.example.bookrentalsystem.globalException.CustomExceptionHandler;
import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.BookTransactionDetailRequestPojo;

import java.util.List;

public interface BookTransactionService {
    Object getBookTransactionById(Integer bookTransactionId);
    void saveBookTransactionDetails(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) throws CustomExceptionHandler;
    public List<BookTransaction> getBookTransaction();

    void addNewTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) throws CustomExceptionHandler;

    void addReturnTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);

//    void addNewReturnTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);

//    void returnBookTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);
}
