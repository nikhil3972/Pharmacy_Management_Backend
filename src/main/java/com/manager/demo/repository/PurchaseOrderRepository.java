/**
 * This interface extends the JpaRepository interface to perform CRUD operations on the Purchase_Order entity.
 * It provides methods for common database operations like save(), findAll(), findById(), deleteById(), etc.
 *
 * @author [Author Name]
 * @version [Version Number]
 */ 
package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {

}