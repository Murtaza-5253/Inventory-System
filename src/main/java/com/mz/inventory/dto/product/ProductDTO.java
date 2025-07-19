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
    @Size(min = 2, max = 100)
    @Column(unique = true)
    private String name;
    @NotBlank(message = "Product category should not be blank")
    private String category;
    @NotNull(message = "Product quantity should not be blank")
    @Min(value = 0, message = "Quantity cannot be negative")
    private int quantity;
    @NotNull(message = "Product price should not be blank")
    @Positive(message = "Price must be positive")
    private double price;

}
