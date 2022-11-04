package com.example.bookrentalsystem.pojo.book;

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
public class BookDetailResponsePojo {
    private Integer bookId;

    private String bookName;


    private Integer noOfPages;


    private String isbn;


    private double rating;


    private Integer stockCount;

    private Date publishedDate;


    private String photo;


    private Integer categoryId;
}
