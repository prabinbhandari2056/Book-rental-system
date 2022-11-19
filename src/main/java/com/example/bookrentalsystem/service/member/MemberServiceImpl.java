package com.example.bookrentalsystem.service.member;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.mapper.MemberDetailMapper;
import com.example.bookrentalsystem.model.Member;
import com.example.bookrentalsystem.pojo.member.MemberDetailRequestPojo;
import com.example.bookrentalsystem.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDetailRequestPojo memberDetailRequestPojo;

    private final ObjectMapper objectMapper;

    private final MemberDetailMapper memberDetailMapper;

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberDetailRequestPojo memberDetailRequestPojo, ObjectMapper objectMapper, MemberDetailMapper memberDetailMapper, MemberRepository memberRepository) {
        this.memberDetailRequestPojo = memberDetailRequestPojo;
        this.objectMapper = objectMapper;
        this.memberDetailMapper = memberDetailMapper;
        this.memberRepository = memberRepository;
    }


    @Override
    public Object getMemberById(Integer memberId) {
        return  memberRepository.findById(memberId);
    }

    @Override
    public void saveMemberDetails(MemberDetailRequestPojo memberDetailRequestPojo) {
        Member member;
        if (memberDetailRequestPojo.getMemberId()!= null)
            member = memberRepository.findById(memberDetailRequestPojo.getMemberId()).orElse(new Member());
        member = objectMapper.convertValue(memberDetailRequestPojo, Member.class);
        memberRepository.save(member);

    }

    @Override
    public List<Member> getMember() {
        return memberRepository.findAll();
    }

    @Override
    public void deleteMemberById(Integer memberId) throws AppException {
        Optional<Member> exists=memberRepository.findById(memberId);
        if (!exists.isPresent()){
            throw new AppException("Member does not exist by given"+ memberId +" Member id");
        }
        else if (exists.isPresent()){
            memberRepository.deleteById(memberId);
        }
    }
}
