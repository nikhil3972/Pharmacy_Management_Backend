/**
 * The SalesRepository interface provides the methods to perform CRUD operations on Sales entities
 * in the database using Spring Data JPA.
 * 
 * It extends the JpaRepository interface, which provides the basic CRUD operations such as save, 
 * delete, and findById.
 * 
 * This interface defines the specific methods that can be used to perform database operations on the 
 * Sales entity, such as findAllByDateBetween, findByCustomer, etc.
 *
 * @author [Your Name]
 * @version 1.0
 * @since [Date on which this class was created]
 */
 
package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer>{

}