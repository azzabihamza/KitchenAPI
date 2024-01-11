package com.kitchenapi.repository;

import com.kitchenapi.model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long>{
    FoodCategory findByName(String name);
}
