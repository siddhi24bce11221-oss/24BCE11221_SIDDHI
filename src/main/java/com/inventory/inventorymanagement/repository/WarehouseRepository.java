package com.inventory.inventorymanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.inventorymanagement.model.Warehouse;

@Repository
public interface WarehouseRepository
        extends MongoRepository<Warehouse, String> {

}