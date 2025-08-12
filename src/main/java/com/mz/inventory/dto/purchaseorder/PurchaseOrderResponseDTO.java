package com.mz.inventory.dto.purchaseorder;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrderResponseDTO {

    private Long id;
    private String supplierName;
    private LocalDate orderDate;
    private String orderStatus;
    private double totalPrice;
    private List<PurchaseOrderItemDTO> items;
}
