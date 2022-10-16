package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.model.Member;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.AuthorDetailRequestPojo;
import com.example.bookrentalsystem.pojo.MemberDetailRequestPojo;
import com.example.bookrentalsystem.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bookrent/member")
public class MemberController extends ApiResponse {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("getmember")
    public List<Member> getMember() {
        return memberService.getMember();
    }

    @PostMapping("savemember")
    public ApiResponse saveMemberDetails(@RequestBody @Valid MemberDetailRequestPojo memberDetailRequestPojo){
        memberService.saveMemberDetails(memberDetailRequestPojo);
        return success("Member Saved Successfully", null);
    }

    @GetMapping("getmember/{memberId}")
    public ApiResponse getMemberById(@PathVariable(name = "memberId") Integer memberId) {
        return success("Member data fetched successuflly", memberService.getMemberById(memberId));
    }
}
