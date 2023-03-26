package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Integer> {

}
