package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.model.Member;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.MemberDetailRequestPojo;
import com.example.bookrentalsystem.service.member.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("bookrent/member")
public class MemberController extends ApiResponse {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping()
    public ApiResponse getMember() {
        return success(get("data.get","Member"),memberService.getMember());
    }

    @PostMapping()
    public ApiResponse saveMemberDetails(@RequestBody @Valid MemberDetailRequestPojo memberDetailRequestPojo){
        memberService.saveMemberDetails(memberDetailRequestPojo);
        return success(get("data.save","Member"), null);
    }

    @GetMapping("/{memberid}")
    public ApiResponse getMemberById(@PathVariable(name = "memberid") Integer memberId) {
        return success(get("data.get","Member"), memberService.getMemberById(memberId));
    }
}
