package com.example.bookrentalsystem.service.category;

import com.example.bookrentalsystem.mapper.CategoryDetailMapper;
import com.example.bookrentalsystem.model.Category;
import com.example.bookrentalsystem.pojo.category.CategoryDetailRequestPojo;
import com.example.bookrentalsystem.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryDetailRequestPojo categoryDetailRequestPojo;

    private final ObjectMapper objectMapper;

    private final CategoryDetailMapper categoryDetailMapper;

    private  final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryDetailRequestPojo categoryDetailRequestPojo, ObjectMapper objectMapper, CategoryDetailMapper categoryDetailMapper, CategoryRepository categoryRepository) {
        this.categoryDetailRequestPojo = categoryDetailRequestPojo;
        this.objectMapper = objectMapper;
        this.categoryDetailMapper = categoryDetailMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Object getCategoryById(Integer categoryId) {
        return categoryDetailMapper.findCategoryById(categoryId);
    }

    @Override
    public void saveCategoryDetails(CategoryDetailRequestPojo categoryDetailRequestPojo) {
        Category category = null;
        if (categoryDetailRequestPojo.getCategoryId()!= null)
            category = categoryRepository.findById(categoryDetailRequestPojo.getCategoryId()).orElse(new Category());
        category = objectMapper.convertValue(categoryDetailRequestPojo, Category.class);
        categoryRepository.save(category);
    }


}
