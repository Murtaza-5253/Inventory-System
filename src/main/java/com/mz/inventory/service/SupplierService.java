package com.mz.inventory.service;

import com.mz.inventory.dto.supplier.SupplierDTO;
import com.mz.inventory.dto.supplier.SupplierResponseDTO;
import com.mz.inventory.exception.ResourceNotFoundException;
import com.mz.inventory.mapper.SupplierMapper;
import com.mz.inventory.model.Supplier;
import com.mz.inventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SupplierService {

    SupplierResponseDTO createSupplier(SupplierDTO supplierDTO);
    List<SupplierResponseDTO> findAllSuppliers();
    SupplierResponseDTO findSupplierById(Long id);
    SupplierResponseDTO updateSupplier(Long id, SupplierDTO supplierDTO);
    void deleteSupplierById(Long id);

}
