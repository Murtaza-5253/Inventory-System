package com.mz.inventory.service.impl;

import com.mz.inventory.dto.product.ProductDTO;
import com.mz.inventory.dto.product.ProductResponseDTO;
import com.mz.inventory.exception.ResourceNotFoundException;
import com.mz.inventory.mapper.ProductMapper;
import com.mz.inventory.model.Product;
import com.mz.inventory.model.Supplier;
import com.mz.inventory.repository.ProductRepository;
import com.mz.inventory.repository.SupplierRepository;
import com.mz.inventory.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private SupplierRepository supplierRepo;


    @Override
    public ProductResponseDTO createProduct(ProductDTO dto) {
        Supplier supplier = supplierRepo.findById(dto.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        Product product = new Product();
        product.setName(dto.getName());
        product.setSupplier(supplier);
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        Product saved =  productRepo.save(product);
        return mapToResponseDTO(saved);
    }



    @Override
    public List<ProductResponseDTO> findAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO findProductById(Long id) {
        Product  product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return mapToResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductDTO dto) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        Supplier supplier = supplierRepo.findById(dto.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        product.setName(dto.getName());
        product.setSupplier(supplier);
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        Product updated = productRepo.save(product);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepo.delete(product);
    }

    private ProductResponseDTO mapToResponseDTO(Product product) {
        return ProductMapper.toDto(product);
    }
}
