package com.example.bookrentalsystem.repository;

import com.example.bookrentalsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
