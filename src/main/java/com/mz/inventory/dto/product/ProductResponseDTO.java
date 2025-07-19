package com.mz.inventory.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String category;
    private int quantity;
    private double price;
}
