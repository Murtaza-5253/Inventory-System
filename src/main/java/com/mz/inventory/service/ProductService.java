package com.mz.inventory.service;

import com.mz.inventory.dto.product.ProductDTO;
import com.mz.inventory.exception.ResourceNotFoundException;
import com.mz.inventory.mapper.ProductMapper;
import com.mz.inventory.model.Product;
import com.mz.inventory.model.Supplier;
import com.mz.inventory.repository.ProductRepository;
import com.mz.inventory.repository.SupplierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private SupplierRepository supplierRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(ProductDTO product) {
        Supplier supplier = supplierRepo.findById(product.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        Product prd = ProductMapper.toEntity(product,supplier);
        return productRepo.save(prd);
    }

    public void deleteProduct(Long id) {
        Product prd = getProductById(id);
        productRepo.delete(prd);
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
    @Transactional
    public Product updateProduct(Long id,ProductDTO productDTO) {
        Product product = getProductById(id);
        Supplier supplier = supplierRepo.findById(productDTO.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setSupplier(supplier);
        return productRepo.save(product);
    }
}
