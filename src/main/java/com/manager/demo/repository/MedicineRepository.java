/**
 * This interface represents the repository for the Medicine entity, providing access to CRUD operations
 * using Spring Data JPA. 
 *
 * @author [Your Name]
 * @version 1.0
 * @since [Date or version]
 */
 
package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manager.demo.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	
}