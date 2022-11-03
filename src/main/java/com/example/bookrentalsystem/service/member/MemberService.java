package com.example.bookrentalsystem.service.member;

import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.model.Member;
import com.example.bookrentalsystem.pojo.AuthorDetailRequestPojo;
import com.example.bookrentalsystem.pojo.MemberDetailRequestPojo;

import java.util.List;

public interface MemberService {
    Object getMemberById(Integer memberId);
    void saveMemberDetails(MemberDetailRequestPojo memberDetailRequestPojo);
    public List<Member> getMember();
}
