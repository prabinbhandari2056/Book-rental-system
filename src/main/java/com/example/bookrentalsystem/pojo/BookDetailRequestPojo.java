package com.example.bookrentalsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookDetailRequestPojo {
    private Integer bookId;

    private String bookName;


    private Integer noOfPages;


    private String isbn;


    private double rating;


    private Integer stockCount;

    private Date publishedDate;


    private String photo;


    private Integer categoryId;

    private List<Integer> authorId;
}
