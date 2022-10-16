package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.model.Category;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.AuthorDetailRequestPojo;
import com.example.bookrentalsystem.pojo.CategoryDetailRequestPojo;
import com.example.bookrentalsystem.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bookrental/category")
public class CategoryController extends ApiResponse{

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("savecategory")
    public ApiResponse saveCategoryDetails(@RequestBody @Valid CategoryDetailRequestPojo categoryDetailRequestPojo){
        categoryService.saveCategoryDetails(categoryDetailRequestPojo);
        return success("Category Saved Successfully", null);
    }
    @GetMapping("getcategory/{categoryId}")
    public ApiResponse getCategoryById(@PathVariable(name = "categoryId") Integer categoryId) {
        return success("Category data fetched successuflly", categoryService.getCategoryById(categoryId));
    }

    @GetMapping("getcategory")
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }

}
