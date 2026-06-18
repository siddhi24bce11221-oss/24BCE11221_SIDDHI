package com.inventory.inventorymanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.inventorymanagement.model.Supplier;

@Repository
public interface SupplierRepository
        extends MongoRepository<Supplier, String> {

}
