package com.mz.inventory.dto.purchaseorder;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrderItemDTO {
    private Long productId;
    private int quantity;
    private double price;
}
