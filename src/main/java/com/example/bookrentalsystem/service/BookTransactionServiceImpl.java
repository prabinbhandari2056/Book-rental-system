package com.example.bookrentalsystem.service;


import com.example.bookrentalsystem.mapper.BookTransactionDetailMapper;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.model.Member;
import com.example.bookrentalsystem.pojo.*;
import com.example.bookrentalsystem.repository.BookRepository;
import com.example.bookrentalsystem.repository.BookTransactionRepository;
import com.example.bookrentalsystem.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class BookTransactionServiceImpl implements BookTransactionService {

    private final BookRepository bookRepository;

    private final MemberRepository memberRepository;
    private final BookTransactionRepository bookTransactionRepository;

    private final BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo;

    private final BookTransactionDetailMapper bookTransactionDetailMapper;

    private final ObjectMapper objectMapper;

    private final ApiResponse apiResponse;

    public BookTransactionServiceImpl(BookRepository bookRepository, MemberRepository memberRepository, BookTransactionRepository bookTransactionRepository,
                                      BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo,
                                      BookTransactionDetailMapper bookTransactionDetailMapper, ObjectMapper objectMapper, ApiResponse apiResponse) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.bookTransactionRepository = bookTransactionRepository;
        this.bookTransactionDetailRequestPojo = bookTransactionDetailRequestPojo;
        this.bookTransactionDetailMapper = bookTransactionDetailMapper;
        this.objectMapper = objectMapper;
        this.apiResponse = apiResponse;
    }

    @Override
    public Object getBookTransactionById(Integer bookTransactionId) {
        BookTransactionDetailResponsePojo bookTransactionDetailResponsePojo = bookTransactionDetailMapper.getBookTransactionById(bookTransactionId);
        return bookTransactionDetailResponsePojo;
    }

    @Override
    public void saveBookTransactionDetails(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) {
        BookTransaction bookTransaction = null;
        if (bookTransactionDetailRequestPojo.getBookTransactionId() != null)
            bookTransaction = bookTransactionRepository.findById(bookTransactionDetailRequestPojo.getBookTransactionId()).orElse(new BookTransaction());
        bookTransaction = objectMapper.convertValue(bookTransactionDetailRequestPojo, BookTransaction.class);
        Book book = bookRepository.findById(bookTransactionDetailRequestPojo.getBookId()).orElseThrow(() -> new RuntimeException("Book does not exist by category id"));
        bookTransaction.setBook(book);
        Member member = memberRepository.findById(bookTransactionDetailRequestPojo.getMemberId()).orElseThrow(() -> new RuntimeException("Member does not exist by category id"));
        bookTransaction.setMember(member);
        bookTransactionRepository.save(bookTransaction);
    }

    @Override
    public List<BookTransaction> getBookTransaction() {
        return bookTransactionRepository.findAll();
    }


    @Transactional
    @Override
    public void addNewTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) {
      if (bookTransactionDetailRequestPojo.getRentType().toString().equalsIgnoreCase("Rent")) {
          BookTransaction bookTransaction = null;
          Member member = memberRepository.findById(bookTransactionDetailRequestPojo.getMemberId()).orElseThrow
                  (() -> new RuntimeException("Member Does not exist by given member id."));
          Book book = bookRepository.findById(bookTransactionDetailRequestPojo.getBookId()).orElseThrow(() ->
                  new RuntimeException("Book does not exist by given book id"));
          String renStatus = bookTransactionDetailMapper.getRentStatus2(bookTransactionDetailRequestPojo.getMemberId());
          Integer bookCount = bookTransactionDetailMapper.getStockCount(bookTransactionDetailRequestPojo.getBookId());
          if (renStatus == null || !renStatus.equalsIgnoreCase("Rent")) {
              if (bookCount >= 1) {
                  if (bookTransactionDetailRequestPojo.getBookTransactionId() != null)
                      bookTransaction = bookTransactionRepository.findById(bookTransactionDetailRequestPojo.getBookTransactionId()).orElse(new BookTransaction());
                  bookTransaction = objectMapper.convertValue(bookTransactionDetailRequestPojo, BookTransaction.class);
                  bookTransaction.setBook(book);
                  bookTransaction.setMember(member);
                  bookTransactionRepository.save(bookTransaction);
                  bookRepository.updateBookRent(bookTransactionDetailRequestPojo.getBookId());
              } else {
                  throw new RuntimeException("Book not available in stock");
              }
          } else {
              throw new RuntimeException("Book already rented for this member id");
          }
      } else if (bookTransactionDetailRequestPojo.getRentType().toString().equalsIgnoreCase("RETURN")) {
          bookTransactionRepository.updateBookReturnTransaction(bookTransactionDetailRequestPojo.getBookId(),bookTransactionDetailRequestPojo.getMemberId());
          bookRepository.updateBookReturn(bookTransactionDetailRequestPojo.getBookId());
      }
    }
    @Transactional
    @Override
    public void addReturnTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) {
        bookTransactionRepository.updateBookReturnTransaction(bookTransactionDetailRequestPojo.getBookId(),bookTransactionDetailRequestPojo.getMemberId());
        bookRepository.updateBookReturn(bookTransactionDetailRequestPojo.getBookId());
    }
}