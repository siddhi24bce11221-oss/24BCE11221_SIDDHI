package com.inventory.inventorymanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.inventorymanagement.model.Category;

@Repository
public interface CategoryRepository
        extends MongoRepository<Category, String> {

}
