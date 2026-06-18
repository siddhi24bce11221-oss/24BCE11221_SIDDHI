package com.inventory.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.inventorymanagement.model.Supplier;
import com.inventory.inventorymanagement.service.SupplierService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
        name = "Supplier APIs",
        description = "APIs for managing suppliers"
)
@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Operation(summary = "Add a new supplier")
    @PostMapping
    public Supplier saveSupplier(
            @Valid @RequestBody Supplier supplier) {

        return supplierService.saveSupplier(supplier);
    }

    @Operation(summary = "Get all suppliers")
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @Operation(summary = "Get supplier by ID")
    @GetMapping("/{id}")
    public Supplier getSupplierById(
            @PathVariable String id) {

        return supplierService.getSupplierById(id);
    }

    @Operation(summary = "Update supplier by ID")
    @PutMapping("/{id}")
    public Supplier updateSupplier(
            @PathVariable String id,
            @Valid @RequestBody Supplier supplier) {

        return supplierService.updateSupplier(
                id, supplier);
    }

    @Operation(summary = "Delete supplier by ID")
    @DeleteMapping("/{id}")
    public String deleteSupplier(
            @PathVariable String id) {

        supplierService.deleteSupplier(id);
        return "Supplier deleted successfully.";
    }
}