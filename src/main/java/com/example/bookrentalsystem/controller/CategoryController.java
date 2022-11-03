package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.model.Category;
import com.example.bookrentalsystem.pojo.ApiResponse;
import com.example.bookrentalsystem.pojo.CategoryDetailRequestPojo;
import com.example.bookrentalsystem.service.category.CategoryService;
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

    @PostMapping()
    public ApiResponse saveCategoryDetails(@RequestBody @Valid CategoryDetailRequestPojo categoryDetailRequestPojo){
        categoryService.saveCategoryDetails(categoryDetailRequestPojo);
        return success(get("data.save","Category"), null);
    }
    @GetMapping("/{categoryid}")
    public ApiResponse getCategoryById(@PathVariable(name = "categoryid") Integer categoryId) {
        return success(get("data.get","Category"), categoryService.getCategoryById(categoryId));
    }

    @GetMapping()
    public ApiResponse getCategory() {
        return  success(get("data.get","Category"),categoryService.getCategory());
    }

}
