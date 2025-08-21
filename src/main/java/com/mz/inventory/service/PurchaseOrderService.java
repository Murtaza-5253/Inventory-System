package com.mz.inventory.service;

import com.mz.inventory.dto.purchaseorder.PurchaseOrderRequestDTO;
import com.mz.inventory.dto.purchaseorder.PurchaseOrderResponseDTO;

import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrderResponseDTO createOrder(PurchaseOrderRequestDTO request);
    PurchaseOrderResponseDTO getOrderById(Long id);
    List<PurchaseOrderResponseDTO> getAllOrders();
}
