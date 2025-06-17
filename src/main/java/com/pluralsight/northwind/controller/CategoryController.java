package com.pluralsight.northwind.controller;


import com.pluralsight.northwind.dao.CategoryDao;
import com.pluralsight.northwind.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

   private CategoryDao categoryDao;


    @Autowired
    public CategoryController(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    @GetMapping("category")
    public List<Category> getAllCategories(){
        return categoryDao.getAllCategories();
    }

    @GetMapping("category/{id}")
    public Category getCategoryById(@PathVariable int categoryId) {
        return categoryDao.getCategoryByID(categoryId);
    }

    @PostMapping("category")
    public void addNewCategory(@RequestBody Category category) {
        categoryDao.addNewCategory(category);
    }

    @PutMapping("category/categories/{id}")
    public void updateCategory(@RequestBody Category category) {
        categoryDao.updateCategory(category);
    }
}
