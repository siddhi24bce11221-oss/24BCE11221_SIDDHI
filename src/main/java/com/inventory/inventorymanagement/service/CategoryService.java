package com.inventory.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventorymanagement.exception.ResourceNotFoundException;
import com.inventory.inventorymanagement.model.Category;
import com.inventory.inventorymanagement.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String id) {
        return categoryRepository.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException(
                    "Category not found with id : " + id));
    }

    public Category updateCategory(String id, Category category) {

        Category existing =
            categoryRepository.findById(id)
                .orElseThrow(() ->
                     new ResourceNotFoundException(
                        "Category not found with id : " + id));

        existing.setCategoryName(category.getCategoryName());
        existing.setDescription(category.getDescription());

        return categoryRepository.save(existing);
    }

    public void deleteCategory(String id) {

        Category category =
             categoryRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Category not found with id : " + id));

        categoryRepository.delete(category);
    }
}