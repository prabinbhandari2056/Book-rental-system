package com.example.bookrentalsystem.pojo.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookDetailIdNameResponsePojo {
    private Integer bookId;

    private String bookName;
}
