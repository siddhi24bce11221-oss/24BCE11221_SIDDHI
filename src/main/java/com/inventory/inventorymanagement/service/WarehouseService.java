package com.inventory.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventorymanagement.exception.ResourceNotFoundException;
import com.inventory.inventorymanagement.model.Warehouse;
import com.inventory.inventorymanagement.repository.WarehouseRepository;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse saveWarehouse(
            Warehouse warehouse) {

        return warehouseRepository.save(warehouse);
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(
            String id) {

        return warehouseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Warehouse not found with id : " + id));
    }

    public Warehouse updateWarehouse(
            String id,
            Warehouse warehouse) {

        Warehouse existing =
                warehouseRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Warehouse not found with id : " + id));

        existing.setWarehouseName(
                warehouse.getWarehouseName());

        existing.setLocation(
                warehouse.getLocation());

        return warehouseRepository.save(existing);
    }

    public void deleteWarehouse(
            String id) {

        Warehouse warehouse =
                warehouseRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Warehouse not found with id : " + id));

        warehouseRepository.delete(warehouse);
    }
}