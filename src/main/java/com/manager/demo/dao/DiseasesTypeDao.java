package com.manager.demo.dao;

import com.manager.demo.entity.DiseaseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseasesTypeDao extends JpaRepository<DiseaseType,Integer> {
}
