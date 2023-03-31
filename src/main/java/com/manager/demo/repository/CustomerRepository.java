package com.manager.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manager.demo.entity.Customer;
import com.manager.demo.entity.CustomerMedicine;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("SELECT new com.manager.demo.entity.CustomerMedicine(c.id, c.firstName, c.lastName, c.email, c.contact, m.name, m.price) FROM Customer c JOIN c.medicine m")
	public List<CustomerMedicine> getMedicineWithCustomer();
}
