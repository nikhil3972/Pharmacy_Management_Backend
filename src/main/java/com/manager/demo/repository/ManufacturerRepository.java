package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

}
