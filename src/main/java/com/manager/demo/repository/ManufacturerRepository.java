package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Manufacturer;

/**
 * The ManufacturerRepository interface is a Spring Data JPA repository that provides CRUD operations for the Manufacturer entity.
 * It extends the JpaRepository interface and specifies the entity type (Manufacturer) and the primary key type (Integer).
 */
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

}
