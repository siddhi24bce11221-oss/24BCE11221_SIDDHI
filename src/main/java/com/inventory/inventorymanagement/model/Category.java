package com.inventory.inventorymanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Document(collection = "categories")
public class Category {

    @Id
    private String id;

    @NotBlank(message = "Category name cannot be empty")
    private String categoryName;

    @NotBlank(message = "Description cannot be empty")
    private String description;
}