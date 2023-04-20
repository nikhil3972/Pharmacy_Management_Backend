
package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Disease;

/**
 * This interface extends JpaRepository interface and provides JPA methods to perform CRUD operations
 * on Disease entity in the database.
 */
public interface DiseaseRepository extends JpaRepository<Disease, Integer> {

}