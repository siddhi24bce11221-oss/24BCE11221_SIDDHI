package com.inventory.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.inventorymanagement.model.Warehouse;
import com.inventory.inventorymanagement.service.WarehouseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
        name = "Warehouse APIs",
        description = "APIs for managing warehouses"
)
@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @Operation(summary = "Add a new warehouse")
    @PostMapping
    public Warehouse saveWarehouse(
            @Valid @RequestBody Warehouse warehouse) {

        return warehouseService.saveWarehouse(
                warehouse);
    }

    @Operation(summary = "Get all warehouses")
    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @Operation(summary = "Get warehouse by ID")
    @GetMapping("/{id}")
    public Warehouse getWarehouseById(
            @PathVariable String id) {

        return warehouseService.getWarehouseById(
                id);
    }

    @Operation(summary = "Update warehouse by ID")
    @PutMapping("/{id}")
    public Warehouse updateWarehouse(
            @PathVariable String id,
            @Valid @RequestBody Warehouse warehouse) {

        return warehouseService.updateWarehouse(
                id,
                warehouse);
    }

    @Operation(summary = "Delete warehouse by ID")
    @DeleteMapping("/{id}")
    public String deleteWarehouse(
            @PathVariable String id) {

        warehouseService.deleteWarehouse(id);

        return "Warehouse deleted successfully.";
    }
}