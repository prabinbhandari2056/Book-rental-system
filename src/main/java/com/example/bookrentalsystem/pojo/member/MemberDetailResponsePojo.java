package com.example.bookrentalsystem.pojo.member;


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
public class MemberDetailResponsePojo {

    private  Integer memberId;

    private  String email;

    private String mobileNo;

    private String address;
}

