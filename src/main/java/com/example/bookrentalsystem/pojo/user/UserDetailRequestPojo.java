package com.example.bookrentalsystem.pojo.user;



import com.example.bookrentalsystem.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailRequestPojo {

    private Integer userId;

    private String userName;

    private String password;

    private UserType userType;

}