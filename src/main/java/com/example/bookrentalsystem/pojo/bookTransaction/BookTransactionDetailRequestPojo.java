package com.example.bookrentalsystem.pojo.bookTransaction;


import com.example.bookrentalsystem.enums.RentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookTransactionDetailRequestPojo {


    private Integer bookTransactionId;


    private Integer bookId;



    private LocalDate toDate;


    private RentType rentType;


    private Integer memberId;

}

