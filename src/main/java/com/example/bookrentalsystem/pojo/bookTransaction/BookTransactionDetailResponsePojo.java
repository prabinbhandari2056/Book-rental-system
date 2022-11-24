package com.example.bookrentalsystem.pojo.bookTransaction;


import com.example.bookrentalsystem.enums.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookTransactionDetailResponsePojo {


    private Integer bookTransactionId;
    private String rentStatus;
    private String code;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDate returnDate;
    private Integer memberId;
    private String memberName;
    private Integer bookId;
    private String bookName;








}

