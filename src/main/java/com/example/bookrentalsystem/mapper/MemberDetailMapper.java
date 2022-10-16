package com.example.bookrentalsystem.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDetailMapper {
    Object findMemberById(Integer memberId);
}
