package com.kitchenapi.controller;

import com.kitchenapi.dto.CategoryRequest;
import com.kitchenapi.services.FoodCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kitchen")
@CrossOrigin(origins = "http://localhost:4200")
public class KitchenRestController {
    private final FoodCategoryService foodCategoryService;

    public KitchenRestController(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }

    @PostMapping(value = "/category",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Object createCategory(@RequestBody CategoryRequest categoryRequest){
        return foodCategoryService.createCategory(categoryRequest.getName());
    }

    @GetMapping(value = "/category")
    @ResponseStatus(value = HttpStatus.OK)
    public Object getAllCategories(){
        return foodCategoryService.getAllCategories();
    }

    @GetMapping(value = "/category/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Object getCategory(@PathVariable Long id){
        return foodCategoryService.getCategory(id);
    }

    @PutMapping(value = "/category/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Object updateCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest){
        return foodCategoryService.updateCategory(id, categoryRequest.getName());
    }

    @DeleteMapping(value = "/category/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Object deleteCategory(@PathVariable Long id){
        return foodCategoryService.deleteCategory(id);
    }
}
