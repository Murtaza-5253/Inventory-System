package com.mz.inventory.service;

import com.mz.inventory.dto.supplier.SupplierDTO;
import com.mz.inventory.exception.ResourceNotFoundException;
import com.mz.inventory.mapper.SupplierMapper;
import com.mz.inventory.model.Supplier;
import com.mz.inventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier addSupplier(SupplierDTO supplierDTO) {
        Supplier supp = SupplierMapper.toEntity(supplierDTO);
        return supplierRepository.save(supp);
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Supplier with id " + id + " not found"));
    }

    public Supplier updateSupplier(Long id, SupplierDTO dto) {

        Supplier supplierToUpdate = getSupplierById(id);
        supplierToUpdate.setName(dto.getName());
        supplierToUpdate.setAddress(dto.getAddress());
        supplierToUpdate.setPhone(dto.getPhone());
        supplierToUpdate.setEmail(dto.getEmail());
        return supplierRepository.save(supplierToUpdate);
    }

    public void deleteSupplier(Long id) {
        Supplier existing = getSupplierById(id);
        supplierRepository.delete(existing);
    }

}
