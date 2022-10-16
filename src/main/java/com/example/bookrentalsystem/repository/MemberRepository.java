package com.example.bookrentalsystem.repository;

import com.example.bookrentalsystem.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    List<Member> findAll();
}
