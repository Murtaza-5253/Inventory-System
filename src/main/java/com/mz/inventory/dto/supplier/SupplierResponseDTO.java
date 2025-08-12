package com.mz.inventory.dto.supplier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierResponseDTO {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;

}
