package com.example.bookrentalsystem.service;


import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.BookTransactionDetailRequestPojo;

import java.util.List;

public interface BookTransactionService {
    Object getBookTransactionById(Integer bookTransactionId);
    void saveBookTransactionDetails(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);
    public List<BookTransaction> getBookTransaction();

    void addNewTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);

    void addReturnTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);

//    void addNewReturnTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);

//    void returnBookTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);
}
