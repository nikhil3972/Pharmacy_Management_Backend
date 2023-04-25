package com.manager.demo.dao;

import com.manager.demo.entity.onlyCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlyCustomerDao extends JpaRepository<onlyCustomer,Integer> {
}
