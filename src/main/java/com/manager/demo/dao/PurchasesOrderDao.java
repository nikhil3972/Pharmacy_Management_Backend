package com.manager.demo.dao;

import com.manager.demo.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasesOrderDao  extends JpaRepository<PurchaseOrder,Integer> {
}
