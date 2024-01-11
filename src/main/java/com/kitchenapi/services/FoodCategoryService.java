package com.kitchenapi.services;

import com.kitchenapi.dto.CategoryResponse;

import java.util.List;

public interface FoodCategoryService {
    Object createCategory(String name);
    Object updateCategory(Long id, String name);
    Object deleteCategory(Long id);
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategory(Long id);
}
