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
public class MemberDetailRequestPojo {
    private  Integer memberId;

    private  String email;

    private String name;

    private String mobileNo;

    private String address;
}

