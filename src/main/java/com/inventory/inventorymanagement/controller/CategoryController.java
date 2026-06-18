package com.inventory.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.inventorymanagement.model.Category;
import com.inventory.inventorymanagement.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
        name = "Category APIs",
        description = "APIs for managing categories"
)
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Add a new category")
    @PostMapping
    public Category saveCategory(
            @Valid @RequestBody Category category) {

        return categoryService.saveCategory(category);
    }

    @Operation(summary = "Get all categories")
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Operation(summary = "Get category by ID")
    @GetMapping("/{id}")
    public Category getCategoryById(
            @PathVariable String id) {

        return categoryService.getCategoryById(id);
    }

    @Operation(summary = "Update category by ID")
    @PutMapping("/{id}")
    public Category updateCategory(
            @PathVariable String id,
            @Valid @RequestBody Category category) {

        return categoryService.updateCategory(id, category);
    }

    @Operation(summary = "Delete category by ID")
    @DeleteMapping("/{id}")
    public String deleteCategory(
            @PathVariable String id) {

        categoryService.deleteCategory(id);
        return "Category deleted successfully.";
    }
}