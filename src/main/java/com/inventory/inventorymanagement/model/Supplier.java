package com.inventory.inventorymanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Document(collection = "suppliers")
public class Supplier {

    @Id
    private String id;

    @NotBlank(message = "Supplier name cannot be empty")
    private String supplierName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotBlank(message = "Phone number cannot be empty")
    private String phone;
}