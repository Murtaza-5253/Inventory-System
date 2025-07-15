package com.mz.inventory.service;

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

    public Product addProduct(Product product) {
        Optional<Product> productOptional = productRepo.findProductByName(product.getName());
        if (productOptional.isPresent()) {
            throw new IllegalStateException("Product already exists");
        }
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        boolean exists = productRepo.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Product not found");
        }
        productRepo.deleteById(id);
    }

    @Transactional
    public void updateProduct(Long id, int quantity, double price,String category) {
        Product product = productRepo.findById(id).
                orElseThrow(()-> new IllegalStateException("Product not found"));
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setCategory(category);
    }
}
