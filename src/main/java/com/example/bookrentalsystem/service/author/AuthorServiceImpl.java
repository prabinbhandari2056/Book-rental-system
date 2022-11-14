package com.example.bookrentalsystem.service.author;

import com.example.bookrentalsystem.mapper.AuthorDetailMapper;
import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.pojo.author.AuthorDetailRequestPojo;
import com.example.bookrentalsystem.pojo.author.AuthorDetailResponsePojo;
import com.example.bookrentalsystem.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDetailRequestPojo authorDetailRequestPojo;

    private final ObjectMapper objectMapper;

    private final AuthorRepository authorRepository;

    private final AuthorDetailMapper authorDetailMapper;

    public AuthorServiceImpl(AuthorDetailRequestPojo authorDetailRequestPojo, ObjectMapper objectMapper, AuthorRepository authorRepository, AuthorDetailMapper authorDetailMapper) {
        this.authorDetailRequestPojo = authorDetailRequestPojo;
        this.objectMapper = objectMapper;
        this.authorRepository = authorRepository;
        this.authorDetailMapper = authorDetailMapper;
    }

    @Override
    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Object getAuthorById(Integer authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public void saveAuthorDetails(AuthorDetailRequestPojo authorDetailRequestPojo) {

        Author author;
        if (authorDetailRequestPojo.getAuthorId() != null)
            author = authorRepository.findById(authorDetailRequestPojo.getAuthorId()).orElse(new Author());
        author = objectMapper.convertValue(authorDetailRequestPojo, Author.class);
        authorRepository.save(author);

    }
}
