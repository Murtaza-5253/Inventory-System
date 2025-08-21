package com.mz.inventory.repository;

import com.mz.inventory.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRespository extends JpaRepository<PurchaseOrder, Long> {
}
