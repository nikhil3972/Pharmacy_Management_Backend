package com.manager.demo.dao;



import com.manager.demo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerMedicineDao extends JpaRepository<Medicine,Integer> {
}
