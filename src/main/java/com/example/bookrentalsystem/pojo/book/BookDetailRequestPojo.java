package com.example.bookrentalsystem.pojo.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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


    private Double rating;


    private Integer stockCount;

    private LocalDate publishedDate;


    private String photo;

    @NotNull
    private Integer categoryId;

    @NotNull
    private List<Integer> authorId;

    private MultipartFile bookImage;
}
