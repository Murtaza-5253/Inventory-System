package com.mz.inventory.service;

import com.mz.inventory.exception.ResourceNotFoundException;
import com.mz.inventory.model.Product;
import com.mz.inventory.model.Supplier;
import com.mz.inventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Supplier Does not exist with id: "+id));
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {

        Supplier supplierToUpdate = getSupplierById(id);
        if (supplierToUpdate == null) {
            throw new IllegalStateException("Supplier with id " + id + " not found");
        }
        supplierToUpdate.setName(supplier.getName());
        supplierToUpdate.setAddress(supplier.getAddress());
        supplierToUpdate.setPhone(supplier.getPhone());
        supplierToUpdate.setEmail(supplier.getEmail());
        return supplierRepository.save(supplierToUpdate);
    }

    public void deleteSupplier(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new IllegalStateException("Supplier with id " + id + " not found");
        }
        supplierRepository.deleteById(id);
    }

}
