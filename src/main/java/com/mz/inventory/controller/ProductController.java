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
        Product product = productService.addProduct(productDto);
        return new ResponseEntity<>(ProductMapper.toDto(product), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDTO> productResponseDTOs = products.stream()
                .map(ProductMapper::toDto)
                .toList();
        return ResponseEntity.ok(productResponseDTOs);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(ProductMapper.toDto(product));
    }

    @PutMapping(path = "/{productId}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable long productId,
                              @Valid @RequestBody ProductDTO product) {
        Product product1 = productService.updateProduct(productId,product);
        return ResponseEntity.ok(ProductMapper.toDto(product1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
