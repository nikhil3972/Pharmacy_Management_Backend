package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
