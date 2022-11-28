package com.example.bookrentalsystem.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponsePojo {
    private Integer userId;
    private String password;

    private String userName;


    private String userType;
}
