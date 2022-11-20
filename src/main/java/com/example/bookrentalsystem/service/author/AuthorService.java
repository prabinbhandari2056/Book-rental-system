package com.example.bookrentalsystem.service.author;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.pojo.author.AuthorDetailRequestPojo;

import java.util.List;

public interface AuthorService {
    Object getAuthorById(Integer authorId);
    void saveAuthorDetails(AuthorDetailRequestPojo authorDetailRequestPojo);
     List<Author> getAuthor();

     void  deleteAuthorById(Integer authorId) throws AppException;
}
