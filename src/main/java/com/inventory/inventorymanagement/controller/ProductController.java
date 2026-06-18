package com.inventory.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.inventorymanagement.model.Product;
import com.inventory.inventorymanagement.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Product APIs", description = "APIs for managing products")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Operation(summary = "Add a new product")
    @PostMapping
    public Product saveProduct(@Valid @RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @Operation(summary = "Get all products")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Operation(summary = "Get product by ID")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @Operation(summary = "Update product by ID")
    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable String id,
            @Valid @RequestBody Product product) {

        return productService.updateProduct(id, product);
    }

    @Operation(summary = "Delete product by ID")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return "Product deleted successfully.";
    }

    @Operation(summary = "Get total number of products")
    @GetMapping("/count")
    public long getCount() {
        return productService.getCount();
    }

    @Operation(summary = "Search products by name")
    @GetMapping("/name/{name}")
    public List<Product> getByName(@PathVariable String name) {
        return productService.getByProductName(name);
    }

    @Operation(summary = "Get products sorted by price")
    @GetMapping("/sort/price")
    public List<Product> getSortedProducts() {
        return productService.getSortedProducts();
    }
}