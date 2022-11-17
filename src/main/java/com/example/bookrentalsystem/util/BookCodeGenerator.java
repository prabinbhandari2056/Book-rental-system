package com.example.bookrentalsystem.util;

import com.example.bookrentalsystem.mapper.BookDetailMapper;
import com.example.bookrentalsystem.pojo.book.BookDetailRequestPojo;
import com.example.bookrentalsystem.pojo.bookTransaction.BookTransactionDetailRequestPojo;
import org.apache.commons.lang3.RandomStringUtils;


public class BookCodeGenerator {
    private final BookDetailMapper bookDetailMapper;
    private final BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo;
    public BookCodeGenerator(BookDetailMapper bookDetailMapper,BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) {
        this.bookDetailMapper = bookDetailMapper;
        this.bookTransactionDetailRequestPojo = bookTransactionDetailRequestPojo;
    }

    public String getRandomString(){
        String bookName=bookDetailMapper.getBookName(bookTransactionDetailRequestPojo.getBookId());
        Integer bookStock=bookDetailMapper.getBookCount(bookTransactionDetailRequestPojo.getBookId());
        String randomString= bookName.substring(0,4)+RandomStringUtils.randomAlphabetic(3)+bookStock+RandomStringUtils.randomNumeric(3)+"00"+bookStock;
        return randomString.toUpperCase();
    }
    }
