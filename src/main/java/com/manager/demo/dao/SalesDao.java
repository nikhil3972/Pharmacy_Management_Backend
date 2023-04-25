package com.manager.demo.dao;

import com.manager.demo.entity.Customer;
import com.manager.demo.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesDao extends JpaRepository<Sales,Integer> {
}
