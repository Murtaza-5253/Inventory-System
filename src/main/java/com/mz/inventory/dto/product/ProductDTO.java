package com.mz.inventory.dto.product;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Valid
public class ProductDTO
{
    @NotBlank(message = "Product name should not be blank")
    @Column(unique = true)
    private String name;
    @PositiveOrZero(message = "Product quantity cannot be negative")
    private int quantity;
    @Positive(message = "Price must be positive")
    private double price;

    private Long supplierId;

}
