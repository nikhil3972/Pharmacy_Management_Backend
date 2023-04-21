
package com.manager.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manager.demo.entity.Customer;
import com.manager.demo.entity.CustomerMedicine;

/**
 * This interface extends the JpaRepository interface for Customer entity and provides additional methods to perform operations on the database.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	/**
	 * This method uses JPQL query to fetch data from the Customer entity and the Medicine entity that is joined with it.
	 * It returns a list of objects of type CustomerMedicine that contains the required data.
	 * @return A list of CustomerMedicine objects containing the required data.
	 */
	@Query("SELECT new com.manager.demo.entity.CustomerMedicine(c.customerId, c.firstName, c.lastName, c.email, c.contact, m.medicineName, m.price) FROM Customer c JOIN c.medicine m")
	public List<CustomerMedicine> getMedicineWithCustomer();
}