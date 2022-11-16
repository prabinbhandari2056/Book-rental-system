package com.example.bookrentalsystem.pojo.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookDetailRequestPojo {
    private Integer bookId;

    @NotNull
    private String bookName;

    @NotNull
    private Integer noOfPages;

    @NotNull
    private String isbn;

    @NotNull
    private Double rating;

    @NotNull
    private Integer stockCount;
    @NotNull
    private LocalDate publishedDate;


//    private String photo;

    @NotNull
    private Integer categoryId;

    @NotNull
    private List<Integer> authorId;
    @NotNull
    private MultipartFile bookImage;
}
