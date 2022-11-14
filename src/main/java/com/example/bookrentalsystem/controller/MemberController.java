package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.pojo.api.ApiResponse;
import com.example.bookrentalsystem.pojo.api.BaseController;
import com.example.bookrentalsystem.pojo.member.MemberDetailRequestPojo;
import com.example.bookrentalsystem.service.member.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("bookrent/member")
public class MemberController extends BaseController {
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
