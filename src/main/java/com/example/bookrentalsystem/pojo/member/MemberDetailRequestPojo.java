package com.example.bookrentalsystem.pojo.member;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Pattern;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class MemberDetailRequestPojo {
    private  Integer memberId;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}",message = "Enter valid email address.")
    private  String email;

    private String name;

    @Pattern(regexp = "^[0-9]{8,10}",message = "Enter valid phone numbers")
    private String mobileNo;

    private String address;
}

