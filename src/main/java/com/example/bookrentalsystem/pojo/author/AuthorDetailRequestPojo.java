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

    @NotNull
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}",message = "Enter valid email address.")
    private String authorEmail;

    @NotNull
    @Pattern(regexp = "^[0-9]{8,10}",message = "Enter valid phone numbers")
    private String authorMobile;
}

