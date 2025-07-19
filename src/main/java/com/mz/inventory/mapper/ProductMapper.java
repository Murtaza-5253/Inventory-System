package com.mz.inventory.mapper;

import com.mz.inventory.dto.product.ProductDTO;
import com.mz.inventory.dto.product.ProductResponseDTO;
import com.mz.inventory.model.Product;
import com.mz.inventory.model.Supplier;

public class ProductMapper {

    public static ProductResponseDTO toDto(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setSupplierName(product.getSupplier().getName());
        return dto;
    }

    public static Product toEntity(ProductDTO dto, Supplier supplier) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setSupplier(supplier);
        return product;
    }
}
