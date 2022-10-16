package com.example.bookrentalsystem.service;

import com.example.bookrentalsystem.model.Category;
import com.example.bookrentalsystem.pojo.CategoryDetailRequestPojo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    Object getCategoryById(Integer categoryId);
    void saveCategoryDetails(CategoryDetailRequestPojo categoryDetailRequestPojo);
    public List<Category> getCategory();
}
