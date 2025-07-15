package com.mz.inventory.controller;

import com.mz.inventory.model.Product;
import com.mz.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(@PathVariable long productId,
                              @RequestBody(required = false) Product product) {
        productService.updateProduct(productId,product.getQuantity(),product.getPrice(),product.getCategory());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
