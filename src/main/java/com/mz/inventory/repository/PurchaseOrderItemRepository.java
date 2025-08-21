package com.mz.inventory.repository;

import com.mz.inventory.model.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem,Long> {
}
