package com.example.bookrentalsystem.pojo.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetailResponsePojo {
    private Integer authorId;

    private  String authorName;

    private String authorEmail;

    private String authorMobile;
}
