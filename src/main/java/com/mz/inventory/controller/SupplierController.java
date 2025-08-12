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
    public ResponseEntity<SupplierResponseDTO> createSupplier(@Valid @RequestBody SupplierDTO supplier) {
        return ResponseEntity.ok(supplierService.createSupplier(supplier));
    }


    @GetMapping
    public ResponseEntity<List<SupplierResponseDTO>> getAllSuppliers() {
       return ResponseEntity.ok(supplierService.findAllSuppliers());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SupplierResponseDTO> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.findSupplierById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SupplierResponseDTO> updateSupplier(@PathVariable Long id, @Valid @RequestBody SupplierDTO supplier) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplier));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.noContent().build();
    }
}
