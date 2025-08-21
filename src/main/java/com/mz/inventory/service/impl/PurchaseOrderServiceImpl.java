package com.mz.inventory.service.impl;

import com.mz.inventory.dto.purchaseorder.PurchaseOrderItemDTO;
import com.mz.inventory.dto.purchaseorder.PurchaseOrderRequestDTO;
import com.mz.inventory.dto.purchaseorder.PurchaseOrderResponseDTO;
import com.mz.inventory.exception.ResourceNotFoundException;
import com.mz.inventory.model.Product;
import com.mz.inventory.model.PurchaseOrder;
import com.mz.inventory.model.PurchaseOrderItem;
import com.mz.inventory.model.Supplier;
import com.mz.inventory.repository.ProductRepository;
import com.mz.inventory.repository.PurchaseOrderRespository;
import com.mz.inventory.repository.SupplierRepository;
import com.mz.inventory.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRespository purchaseOrderRespository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public PurchaseOrderResponseDTO createOrder(PurchaseOrderRequestDTO request) {
        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(()->new ResourceNotFoundException("Supplier not found"));
        PurchaseOrder  purchaseOrder = new PurchaseOrder();
        purchaseOrder.setSupplier(supplier);
        purchaseOrder.setOrderDate(LocalDate.now());
        purchaseOrder.setStatus("PENDING");

        List<PurchaseOrderItem> items = request.getItems().stream()
                .map(itemDTO -> {
                    Product product = productRepository.findById(itemDTO.getProductId())
                            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
                    PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
                    purchaseOrderItem.setProduct(product);
                    purchaseOrderItem.setQuantity(itemDTO.getQuantity());
                    purchaseOrderItem.setPrice(product.getPrice());
                    purchaseOrderItem.setPurchaseOrder(purchaseOrder);
                    return purchaseOrderItem;
                }).toList();
        purchaseOrder.setItems(items);
        purchaseOrder.setTotalPrice(items.stream()
        .mapToDouble(i->i.getPrice()*i.getQuantity())
                .sum());
        PurchaseOrder savedPurchaseOrder = purchaseOrderRespository.save(purchaseOrder);
        return mapToResponse(savedPurchaseOrder);
    }

    private PurchaseOrderResponseDTO mapToResponse(PurchaseOrder order) {
        List<PurchaseOrderItemDTO> itemDTOS = order.getItems()
                .stream().map(i-> new PurchaseOrderItemDTO(
                        i.getProduct().getId(),
                        i.getQuantity(),
                        i.getPrice()
                )).toList();
        return new PurchaseOrderResponseDTO(
                order.getId(),
                order.getSupplier().getName(),
                order.getOrderDate(),
                order.getStatus(),
                order.getTotalPrice(),
                itemDTOS
        );
    }

    @Override
    public PurchaseOrderResponseDTO getOrderById(Long id) {
        return null;
    }

    @Override
    public List<PurchaseOrderResponseDTO> getAllOrders() {
        return List.of();
    }
}
