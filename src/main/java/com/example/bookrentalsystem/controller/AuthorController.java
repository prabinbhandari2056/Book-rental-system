package com.example.bookrentalsystem.controller;
import com.example.bookrentalsystem.apiResponse.ApiResponse;
import com.example.bookrentalsystem.pojo.author.AuthorDetailRequestPojo;
import com.example.bookrentalsystem.service.author.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * This class is used to save and update author.
 */
@RestController
@RequestMapping("bookrental/author")
public class AuthorController extends ApiResponse {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * It returns all data from databases.
     * @return List of Authors.
     */
    @Operation(description = "It returns all data from databases ",summary = "Author controller")
    @GetMapping()
    public  ApiResponse  getAuthor() {
        return  success( get("data.get","Author"),authorService.getAuthor());
    }

    @PostMapping()
    public ApiResponse saveAuthorDetails(@RequestBody @Valid AuthorDetailRequestPojo authorDetailRequestPojo) {
        authorService.saveAuthorDetails(authorDetailRequestPojo);
        return success(get("data.save","Author"), null);
    }

    @GetMapping("/{authorid}")
    public ApiResponse getAuthorById(@PathVariable(name = "authorid") Integer authorId) {
        return success(get("data.get","Author"), authorService.getAuthorById(authorId));
    }
}
