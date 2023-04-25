package com.manager.demo.dao;

import com.manager.demo.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface customerDao extends JpaRepository<Customer,Integer> {

}
