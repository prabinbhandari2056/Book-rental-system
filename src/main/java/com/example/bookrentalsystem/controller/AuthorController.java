package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.AuthorDetailRequestPojo;
import com.example.bookrentalsystem.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bookrental/author")
public class AuthorController extends ApiResponse {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("getauthor")
    public List<Author> getAuthor() {
        return authorService.getAuthor();
    }

    @PostMapping("saveauthor")
    public ApiResponse saveAuthorDetails(@RequestBody @Valid AuthorDetailRequestPojo authorDetailRequestPojo){
            authorService.saveAuthorDetails(authorDetailRequestPojo);
            return success("Author Saved Successfully", null);
    }

    @GetMapping("getauthor/{authorId}")
    public ApiResponse getAuthorById(@PathVariable(name = "authorId") Integer authorId) {
        return success("Student data fetched successuflly", authorService.getAuthorById(authorId));
    }
}
