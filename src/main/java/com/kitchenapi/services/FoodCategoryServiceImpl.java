package com.kitchenapi.services;

import com.kitchenapi.dto.CategoryResponse;
import com.kitchenapi.model.FoodCategory;
import com.kitchenapi.repository.FoodCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class FoodCategoryServiceImpl implements FoodCategoryService{
    static String categoryNotFound = "Category not found";
    private final FoodCategoryRepository foodCategoryRepository;

    public FoodCategoryServiceImpl(FoodCategoryRepository foodCategoryRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
    }
    @Override
    public Object createCategory(String name) {
        // add category to database if name is not empty
        if (name == null || name.isEmpty()) {
            return "Category name cannot be empty";
        }
        FoodCategory foodCategory = FoodCategory.builder()
                .name(name)
                .build();
        foodCategoryRepository.save(foodCategory);
        return "Category  : "+foodCategory.getName()+ " created successfully";
    }

    @Override
    public Object updateCategory(Long id, String name) {
        // update category if name is not empty
        if (name == null || name.isEmpty()) {
            return "Category name cannot be empty";
        }
        FoodCategory foodCategory = foodCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(categoryNotFound));
        foodCategory.setName(name);
        foodCategoryRepository.save(foodCategory);
        return "Category ID : "+foodCategory.getId()+ "updated successfully";
    }

    @Override
    public Object deleteCategory(Long id) {
        // delete category if exists
        FoodCategory foodCategory = foodCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(categoryNotFound));
        foodCategoryRepository.delete(foodCategory);
        return "Category ID : "+foodCategory.getId()+ "deleted successfully";
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        // get all categories
        List<FoodCategory> foodCategories = foodCategoryRepository.findAll();
        return foodCategories.stream().map(this::mapCategoryToCategoryResponse).toList();
    }

    @Override
    public CategoryResponse getCategory(Long id) {
        // get category by id
        FoodCategory foodCategory = foodCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(categoryNotFound));
        return mapCategoryToCategoryResponse(foodCategory);
    }

    private CategoryResponse mapCategoryToCategoryResponse(FoodCategory foodCategory) {
        return CategoryResponse.builder()
                .id(foodCategory.getId())
                .name(foodCategory.getName())
                .build();
    }
}
