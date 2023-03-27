package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer>{

}
