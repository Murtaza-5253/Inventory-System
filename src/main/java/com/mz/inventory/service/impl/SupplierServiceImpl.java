package com.mz.inventory.service.impl;

import com.mz.inventory.dto.supplier.SupplierDTO;
import com.mz.inventory.dto.supplier.SupplierResponseDTO;
import com.mz.inventory.exception.ResourceNotFoundException;
import com.mz.inventory.mapper.SupplierMapper;
import com.mz.inventory.model.Supplier;
import com.mz.inventory.repository.SupplierRepository;
import com.mz.inventory.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierResponseDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier  supplier = new Supplier();
        supplier.setName(supplierDTO.getName());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPhone(supplierDTO.getPhone());
        Supplier savedSupplier = supplierRepository.save(supplier);
        return mapToResponseDTO(savedSupplier);
    }

    @Override
    public List<SupplierResponseDTO> findAllSuppliers() {
        return supplierRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierResponseDTO findSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Supplier not found with id: " + id));
        return mapToResponseDTO(supplier);
    }

    @Override
    public SupplierResponseDTO updateSupplier(Long id,SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Supplier not found with id: " + id));
        supplier.setName(supplierDTO.getName());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPhone(supplierDTO.getPhone());

        Supplier updatedSupplier = supplierRepository.save(supplier);
        return mapToResponseDTO(updatedSupplier);
    }

    @Override
    public void deleteSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Supplier not found with id: " + id));
        supplierRepository.delete(supplier);
    }

    private SupplierResponseDTO mapToResponseDTO(Supplier supplier) {
        SupplierResponseDTO supplierResponseDTO = new SupplierResponseDTO();
        supplierResponseDTO.setId(supplier.getId());
        supplierResponseDTO.setName(supplier.getName());
        supplierResponseDTO.setAddress(supplier.getAddress());
        supplierResponseDTO.setEmail(supplier.getEmail());
        supplierResponseDTO.setPhone(supplier.getPhone());
        return supplierResponseDTO;
    }
}
