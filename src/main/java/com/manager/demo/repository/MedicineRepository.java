package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	
}
