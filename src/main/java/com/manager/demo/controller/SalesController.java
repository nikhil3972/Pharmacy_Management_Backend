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

import com.manager.demo.entity.Sales;
import com.manager.demo.repository.SalesRepository;

@RestController
public class SalesController {

	@Autowired
	SalesRepository saleRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllSales")
	public List<Sales> getAllSales() {
		List<Sales> sale = saleRepo.findAll();
		System.out.println("Get list of all Sales successfully");
		return sale;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertSales")
	public String insertSales(@RequestBody Sales obj) {
		System.out.println("Received data : " + obj);
		saleRepo.save(obj);
		return "Record Inserted Successfully";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateSales")
	public String updateSales(@RequestBody Sales obj) {
		Optional<Sales> sale = saleRepo.findById(obj.getId());
		
		if(sale.isPresent()) {
			Sales saleUpd = sale.get();
			saleUpd.setDate(obj.getDate());
			saleUpd.setCustomer(obj.getCustomer());
			saleUpd.setTotal_cost(obj.getTotal_cost());
			saleUpd.setCreated_by(obj.getCreated_by());
			saleUpd.setModified_by(obj.getModified_by());
			saleUpd.setCreated_ts(obj.getCreated_ts());
			saleUpd.setModified_ts(obj.getModified_ts());
			System.out.println("Received Data in PutMapping :" + obj);
			saleRepo.save(obj);
			return "Record Updated Successfully";
		}
		else {
			return "Unable to update the record";
		}
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteSales/{id}")
	public String deleteSales(@PathVariable int id) {
		System.out.println("Sales record deleted. Given id : " + id);
		saleRepo.deleteById(id);
		return "Record Deleted Successfully";
	}
	
}
