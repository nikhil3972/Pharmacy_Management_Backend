package com.manager.demo.dao;



import com.manager.demo.entity.CustomerMedicine;
import com.manager.demo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerMedicineDao extends JpaRepository<Medicine,Integer> {
    @Query("SELECT new com.manager.demo.entity.CustomerMedicine(c.customerId, c.firstName, c.lastName, c.email, c.contact, m.medicineName, m.price) FROM Customer c JOIN c.medicine m")
    public List<CustomerMedicine> getMedicineCustomer();
}
