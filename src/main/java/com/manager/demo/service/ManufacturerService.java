package com.manager.demo.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


import com.manager.demo.dao.ManufacturerDao;
import com.manager.demo.dao.customerDao;
import com.manager.demo.entity.Customer;
import com.manager.demo.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class  ManufacturerService {

	@Autowired
	private ManufacturerDao dao;
	public String addManufacturer( Manufacturer manufacturer){
		dao.save(manufacturer);
		return "CustomerMedicine added";
	}
	public String deleteManufacturer(int id){
		Manufacturer manufacturer=dao.getById(id);
		dao.delete(manufacturer);
		return "Customer deleted "+id;
	}
	public String updateManufacturer( Manufacturer manufacturer){
		dao.save(manufacturer);
		return "customer Updated";
	}
	public List< Manufacturer> getManufacturer(){
		List< Manufacturer> manufacturer=dao.findAll();
		return manufacturer;
	}
}
