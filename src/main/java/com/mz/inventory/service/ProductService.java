package com.mz.inventory.service;

import com.mz.inventory.dto.product.ProductDTO;
import com.mz.inventory.mapper.ProductMapper;
import com.mz.inventory.model.Product;
import com.mz.inventory.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(ProductDTO product) {
        Product prd = ProductMapper.toEntity(product);
        return productRepo.save(prd);
    }

    public void deleteProduct(Long id) {
        Product prd = getProductById(id);
        productRepo.delete(prd);
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).
                orElseThrow(() -> new IllegalStateException("Product not found"));
    }
    @Transactional
    public Product updateProduct(Long id,ProductDTO productDTO) {
        Product product = getProductById(id);
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        return productRepo.save(product);
    }
}
