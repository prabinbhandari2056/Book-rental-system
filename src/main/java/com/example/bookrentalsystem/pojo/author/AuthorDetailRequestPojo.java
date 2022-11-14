package com.example.bookrentalsystem.pojo.author;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class AuthorDetailRequestPojo {

    private Integer authorId;

    @NotNull
    private  String authorName;


    private String authorEmail;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",message = "Enter valid phone numbers")
    private String authorMobile;
}

