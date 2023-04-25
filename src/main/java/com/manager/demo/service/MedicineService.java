package com.manager.demo.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.manager.demo.dao.CustomerMedicineDao;
import com.manager.demo.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MedicineService {
	@Autowired
	private CustomerMedicineDao dao;
	public String addMedicine(Medicine medicine){
		dao.save(medicine);
		return "Medicine added";
	}
	public String deleteMedicine(int id){
		Medicine medicine=dao.getById(id);
		dao.delete(medicine);
		return "Mediciner deleted "+id;
	}
	public String updateMedicine(Medicine medicine){
		dao.save(medicine);
		return "Medicine Updated";
	}
	public List<Medicine> getMedicine(){
		List<Medicine> medicine=dao.findAll();
		return medicine;
	}

}
