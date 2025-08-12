package com.mz.inventory.service;

import com.mz.inventory.dto.product.ProductDTO;
import com.mz.inventory.dto.product.ProductResponseDTO;
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
public interface ProductService {

    ProductResponseDTO  createProduct(ProductDTO dto);
    List<ProductResponseDTO> findAllProducts();
    ProductResponseDTO findProductById(Long id);
    ProductResponseDTO updateProduct(Long id, ProductDTO dto);
    void deleteProduct(Long id);


}
