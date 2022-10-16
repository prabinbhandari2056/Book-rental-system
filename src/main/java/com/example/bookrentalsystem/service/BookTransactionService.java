package com.example.bookrentalsystem.service;


import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.pojo.BookTransactionDetailRequestPojo;

import java.util.List;

public interface BookTransactionService {
    Object getBookTransactionById(Integer bookTransactionId);
    void saveBookTransactionDetails(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo);
    public List<BookTransaction> getBookTransaction();
}
