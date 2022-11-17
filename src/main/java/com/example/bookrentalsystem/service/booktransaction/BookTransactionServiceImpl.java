package com.example.bookrentalsystem.service.booktransaction;


import com.example.bookrentalsystem.enums.RentType;
import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.mapper.BookDetailMapper;
import com.example.bookrentalsystem.mapper.BookTransactionDetailMapper;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.model.BookTransaction;
import com.example.bookrentalsystem.model.Member;
import com.example.bookrentalsystem.pojo.api.ApiResponse;
import com.example.bookrentalsystem.pojo.bookTransaction.BookTransactionDetailRequestPojo;
import com.example.bookrentalsystem.repository.BookRepository;
import com.example.bookrentalsystem.repository.BookTransactionRepository;
import com.example.bookrentalsystem.repository.MemberRepository;
import com.example.bookrentalsystem.util.BookCodeGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class BookTransactionServiceImpl implements BookTransactionService {

    private final BookRepository bookRepository;

    private final MemberRepository memberRepository;
    private final BookTransactionRepository bookTransactionRepository;


    private final BookTransactionDetailMapper bookTransactionDetailMapper;
    private final BookDetailMapper bookDetailMapper;

    private final ObjectMapper objectMapper;


    public BookTransactionServiceImpl(BookRepository bookRepository, MemberRepository memberRepository, BookTransactionRepository bookTransactionRepository,
                                      BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo,
                                      BookTransactionDetailMapper bookTransactionDetailMapper, ObjectMapper objectMapper, ApiResponse apiResponse, BookDetailMapper bookDetailMapper) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.bookTransactionRepository = bookTransactionRepository;
        this.bookTransactionDetailMapper = bookTransactionDetailMapper;
        this.objectMapper = objectMapper;

        this.bookDetailMapper = bookDetailMapper;
    }

    @Override
    public Object getBookTransactionById(Integer bookTransactionId) {
        return bookTransactionRepository.findById(bookTransactionId);
    }


    @Override
    public List<BookTransaction> getBookTransaction() {
        return bookTransactionRepository.findAll();
    }


    @Transactional
    @Override
    public void addNewTransaction(BookTransactionDetailRequestPojo bookTransactionDetailRequestPojo) throws AppException {
      if (bookTransactionDetailRequestPojo.getRentType().toString().equalsIgnoreCase("RENT")) {
          if (bookTransactionDetailRequestPojo.getBookId()==null){
              throw new AppException("Book Id can not be null");
          }
         else if (bookTransactionDetailRequestPojo.getMemberId()==null){
              throw new AppException("Member Id can not be null");
          }
          else if (bookTransactionDetailRequestPojo.getToDate()==null){
              throw new AppException("Rent till date  can not be null");
          }
          BookTransaction bookTransaction ;
          Member member = memberRepository.findById(bookTransactionDetailRequestPojo.getMemberId()).orElseThrow
                  (() -> new AppException("Member Does not exist by given member id."));
          Book book = bookRepository.findById(bookTransactionDetailRequestPojo.getBookId()).orElseThrow(() ->
                  new AppException("Book does not exist by given book id"));
          Boolean rentStatus = bookTransactionDetailMapper.getRentStatus(bookTransactionDetailRequestPojo.getMemberId());
          if (rentStatus!=null && !rentStatus) {
              throw new AppException("Already rented");
          }
              Integer bookCount = bookTransactionDetailMapper.getStockCount(bookTransactionDetailRequestPojo.getBookId());
              if (bookCount >= 1) {
                  if (bookTransactionDetailRequestPojo.getBookTransactionId() != null)
                      bookTransaction = bookTransactionRepository.findById(bookTransactionDetailRequestPojo.getBookTransactionId()).orElse(new BookTransaction());
                  bookTransaction = objectMapper.convertValue(bookTransactionDetailRequestPojo, BookTransaction.class);
                  bookTransaction.setBook(book);
                  bookTransaction.setMember(member);
                  BookCodeGenerator bookCodeGenerator=new BookCodeGenerator(bookDetailMapper,bookTransactionDetailRequestPojo);
                  String bookCode=bookCodeGenerator.getRandomString();
                  bookTransaction.setCode(bookCode);
                  bookTransaction.setFromDate(java.time.LocalDate.now());
                  bookTransactionRepository.save(bookTransaction);
                  bookRepository.updateBookRent(bookTransactionDetailRequestPojo.getBookId());
              } else {
                  throw new AppException("Book not available in stock");
              }

      }
       else if (bookTransactionDetailRequestPojo.getRentType().toString().equalsIgnoreCase("RETURN")) {
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