package com.mz.inventory.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class SupplierDTO {

    @NotBlank(message = "Supplier name is required")
    private String name;
    @NotBlank(message = "Supplier address is required")
    private String address;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be exactly 10 digits")
    @NotBlank(message = "Supplier number is required")
    private String phone;
    @NotBlank(message = "Supplier email is required")
    @Email(message = "Invalid email format")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
