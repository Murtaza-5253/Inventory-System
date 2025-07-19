package com.mz.inventory.dto.supplier;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Valid
public class SupplierDTO {

    @NotBlank(message = "Supplier name is required")
    @Size(min = 2, max = 100)
    private String name;
    @NotBlank(message = "Supplier address is required")
    @Size(max = 200)
    private String address;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be exactly 10 digits")
    @NotBlank(message = "Supplier number is required")
    @Column(unique = true)
    private String phone;
    @NotBlank(message = "Supplier email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

}
