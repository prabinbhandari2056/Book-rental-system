package com.example.bookrentalsystem.service;

import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.pojo.AuthorDetailRequestPojo;

import java.util.List;

public interface AuthorService {
    Object getAuthorById(Integer authorId);
    void saveAuthorDetails(AuthorDetailRequestPojo authorDetailRequestPojo);
    public List<Author> getAuthor();
}
