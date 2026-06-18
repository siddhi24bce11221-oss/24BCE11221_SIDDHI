package com.inventory.inventorymanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Document(collection = "warehouses")
public class Warehouse {

    @Id
    private String id;

    @NotBlank(message = "Warehouse name cannot be empty")
    private String warehouseName;

    @NotBlank(message = "Location cannot be empty")
    private String location;
}