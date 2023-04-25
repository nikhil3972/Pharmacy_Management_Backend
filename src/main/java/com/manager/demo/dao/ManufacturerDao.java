package com.manager.demo.dao;

import com.manager.demo.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerDao  extends JpaRepository<Manufacturer,Integer> {
}
