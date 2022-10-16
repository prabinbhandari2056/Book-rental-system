package com.example.bookrentalsystem.repository;

import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.model.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookTransactionRepository extends JpaRepository<BookTransaction,Integer> {
    List<BookTransaction> findAll();
}
