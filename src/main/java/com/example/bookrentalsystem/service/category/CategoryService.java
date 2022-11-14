package com.example.bookrentalsystem.service.category;

import com.example.bookrentalsystem.model.Category;
import com.example.bookrentalsystem.pojo.category.CategoryDetailRequestPojo;

import java.util.List;

public interface CategoryService {
    Object getCategoryById(Integer categoryId);
    void saveCategoryDetails(CategoryDetailRequestPojo categoryDetailRequestPojo);
    public List<Category> getCategory();
}
