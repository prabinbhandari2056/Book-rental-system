package com.example.bookrentalsystem.service;


import com.example.bookrentalsystem.mapper.BookTransactionDetailMapper;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.model.Member;
import com.example.bookrentalsystem.pojo.BookTransactionDetailRequestPojo;
import com.example.bookrentalsystem.pojo.BookTransactionDetailResponsePojo;
import com.example.bookrentalsystem.repository.BookRepository;
import com.example.bookrentalsystem.repository.BookTransactionRepository;
import com.example.bookrentalsystem.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookTransactionServiceImpl implements  BookTransactionService{

    private final BookRepository bookRepository;

    private final MemberRepository memberRepository;
    private final BookTransactionRepository bookTransactionRepository;

    private final BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo;

    private final BookTransactionDetailMapper bookTransactionDetailMapper;

    private final ObjectMapper objectMapper;

    public BookTransactionServiceImpl(BookRepository bookRepository, MemberRepository memberRepository, BookTransactionRepository bookTransactionRepository,
                                      BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo,
                                      BookTransactionDetailMapper bookTransactionDetailMapper, ObjectMapper objectMapper) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.bookTransactionRepository = bookTransactionRepository;
        this.bookTransactionDetailRequestPojo = bookTransactionDetailRequestPojo;
        this.bookTransactionDetailMapper = bookTransactionDetailMapper;
        this.objectMapper = objectMapper;
    }

    @Override
    public Object getBookTransactionById(Integer bookTransactionId) {
        BookTransactionDetailResponsePojo bookTransactionDetailResponsePojo=bookTransactionDetailMapper.getBookTransactionById(bookTransactionId);
        return  bookTransactionDetailResponsePojo;
    }

    @Override
    public void saveBookTransactionDetails(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) {
        BookTransaction bookTransaction = null;
        if (bookTransactionDetailRequestPojo.getBookTransactionId()!= null)
            bookTransaction = bookTransactionRepository.findById(bookTransactionDetailRequestPojo.getBookTransactionId()).orElse(new BookTransaction());
        bookTransaction = objectMapper.convertValue(bookTransactionDetailRequestPojo, BookTransaction.class);
        Book book=bookRepository.findById(bookTransactionDetailRequestPojo.getBookId()).orElseThrow(()->new RuntimeException("Book does not exist by category id"));
        bookTransaction.setBook(book);
        Member member=memberRepository.findById(bookTransactionDetailRequestPojo.getMemberId()).orElseThrow(()->new RuntimeException("Member does not exist by category id"));
        bookTransaction.setMember(member);

        bookTransactionRepository.save(bookTransaction);
    }

    @Override
    public List<BookTransaction> getBookTransaction() {
        return bookTransactionRepository.findAll();
    }
}
