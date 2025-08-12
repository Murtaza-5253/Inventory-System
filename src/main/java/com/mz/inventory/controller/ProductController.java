package com.mz.inventory.controller;

import com.mz.inventory.dto.product.ProductDTO;
import com.mz.inventory.dto.product.ProductResponseDTO;
import com.mz.inventory.mapper.ProductMapper;
import com.mz.inventory.model.Product;
import com.mz.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductDTO productDto) {
        return ResponseEntity.ok(productService.createProduct(productDto));
    }
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @PutMapping(path = "/{productId}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable long productId,
                              @Valid @RequestBody ProductDTO product) {
       return ResponseEntity.ok(productService.updateProduct(productId, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
