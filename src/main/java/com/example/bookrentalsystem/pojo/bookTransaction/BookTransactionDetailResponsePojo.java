package com.example.bookrentalsystem.pojo.bookTransaction;


import com.example.bookrentalsystem.enums.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookTransactionDetailResponsePojo {


    private Integer bookTransactionId;

    private Integer bookId;

    private String code;

    private Date fromDate;

    private Date toDate;


    private RentType rentType;


    private Integer memberId;

    private String status;
}

