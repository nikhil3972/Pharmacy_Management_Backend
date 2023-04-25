package com.manager.demo.dao;

import com.manager.demo.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisaeseDao extends JpaRepository<Disease,Integer> {
}
