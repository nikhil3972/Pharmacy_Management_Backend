package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manager.demo.entity.Purchase_Order;
import com.manager.demo.repository.Purchase_OrderRepository;

@RestController
public class Purchase_OrderController {

	@Autowired
	Purchase_OrderRepository purOrRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllPurchase_Order")
	public List<Purchase_Order> getAllPurchase_Order() {
		List<Purchase_Order> purOr = purOrRepo.findAll();
		System.out.println("Get list of all Purchase_Order successfully");
		return purOr;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertPurchase_Order")
	public String insertPurchase_Order(@RequestBody Purchase_Order obj) {
		System.out.println("Received data : " + obj);
		purOrRepo.save(obj);
		return "Record Inserted Successfully";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updatePurchase_Order")
	public String updateManufacturer(@RequestBody Purchase_Order obj) {
		Optional<Purchase_Order> purOr = purOrRepo.findById(obj.getId());
		
		if(purOr.isPresent()) {
			Purchase_Order purOrUpd = purOr.get();
			purOrUpd.setDate(obj.getDate());
			purOrUpd.setManufacturer(obj.getManufacturer());
			purOrUpd.setExpected_delivery_date(obj.getExpected_delivery_date());
			purOrUpd.setTotal_cost(obj.getTotal_cost());
			purOrUpd.setCreated_by(obj.getCreated_by());
			purOrUpd.setModified_by(obj.getModified_by());
			purOrUpd.setCreated_ts(obj.getCreated_ts());
			purOrUpd.setModified_ts(obj.getModified_ts());
			System.out.println("Received Data in PutMapping :" + obj);
			purOrRepo.save(obj);
			return "Record Updated Successfully";
		}
		else {
			return "Unable to update the record";
		}
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deletePurchase_Order/{id}")
	public String deletePurchase_Order(@PathVariable int id) {
		System.out.println("Purchase_Order record deleted. Given id : " + id);
		purOrRepo.deleteById(id);
		return "Record Deleted Successfully";
	}
}
