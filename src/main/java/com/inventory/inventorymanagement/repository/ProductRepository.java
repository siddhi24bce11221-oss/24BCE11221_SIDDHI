package com.inventory.inventorymanagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.inventorymanagement.model.Product;

@Repository
public interface ProductRepository
        extends MongoRepository<Product, String> {
                // Custom query method
    List<Product> findByProductName(String productName);

    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
}