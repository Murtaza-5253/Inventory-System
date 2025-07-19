package com.mz.inventory.controller;

import com.mz.inventory.dto.supplier.SupplierDTO;
import com.mz.inventory.dto.supplier.SupplierResponseDTO;
import com.mz.inventory.mapper.SupplierMapper;
import com.mz.inventory.model.Supplier;
import com.mz.inventory.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDTO> addSupplier(@Valid @RequestBody SupplierDTO supplier) {
        Supplier supp = supplierService.addSupplier(supplier);
        return new ResponseEntity<>(SupplierMapper.toDto(supp), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<SupplierResponseDTO>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        List<SupplierResponseDTO> response = suppliers.stream()
                .map(SupplierMapper::toDto)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SupplierResponseDTO> getSupplierById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return ResponseEntity.ok(SupplierMapper.toDto(supplier));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SupplierResponseDTO> updateSupplier(@PathVariable Long id, @Valid @RequestBody SupplierDTO supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        SupplierResponseDTO responseDTO = SupplierMapper.toDto(updatedSupplier);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
