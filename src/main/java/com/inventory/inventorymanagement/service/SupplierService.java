package com.inventory.inventorymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventorymanagement.exception.ResourceNotFoundException;
import com.inventory.inventorymanagement.model.Supplier;
import com.inventory.inventorymanagement.repository.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(String id) {

        return supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Supplier not found with id : " + id));
    }

    public Supplier updateSupplier(
            String id,
            Supplier supplier) {

        Supplier existing =
                supplierRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Supplier not found with id : " + id));

        existing.setSupplierName(
                supplier.getSupplierName());

        existing.setEmail(
                supplier.getEmail());

        existing.setPhone(
                supplier.getPhone());

        return supplierRepository.save(existing);
    }

    public void deleteSupplier(String id) {

        Supplier supplier =
                supplierRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Supplier not found with id : " + id));

        supplierRepository.delete(supplier);
    }
}