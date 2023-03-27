package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Purchase_Order;

public interface Purchase_OrderRepository extends JpaRepository<Purchase_Order, Integer> {

}
