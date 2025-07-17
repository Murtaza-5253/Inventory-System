package com.mz.inventory.mapper;

import com.mz.inventory.dto.SupplierDTO;
import com.mz.inventory.dto.SupplierResponseDTO;
import com.mz.inventory.model.Supplier;

public class SupplierMapper {

    public static Supplier toEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierDTO.getName());
        supplier.setPhone(supplierDTO.getPhone());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setAddress(supplierDTO.getAddress());
        return supplier;
    }

    public static SupplierResponseDTO toDto(Supplier supplier) {
        SupplierResponseDTO dto = new SupplierResponseDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setPhone(supplier.getPhone());
        dto.setEmail(supplier.getEmail());
        dto.setAddress(supplier.getAddress());
        return dto;
    }
}
