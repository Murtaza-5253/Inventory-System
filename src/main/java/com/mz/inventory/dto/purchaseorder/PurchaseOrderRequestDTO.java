package com.mz.inventory.dto.purchaseorder;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrderRequestDTO {
    private Long supplierId;
    private List<PurchaseOrderItemDTO>  items;
}
