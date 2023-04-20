package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.DiseaseType;

/**
 * A repository interface for managing Disease_Type entities in the database.
 * 
 * This interface extends the JpaRepository interface, which provides the basic CRUD operations for Disease_Type entities
 * using Spring Data JPA. The Disease_Type entity is the type of the managed entity and Integer is the type of the ID of the entity.
 *
 * @author [Author Name]
 * @version [Version Number]
 * @since 2023
 */
public interface DiseaseTypeRepository extends JpaRepository<DiseaseType, Integer> {
}
