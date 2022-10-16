package com.example.bookrentalsystem.repository;

import com.example.bookrentalsystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findAll();
}
