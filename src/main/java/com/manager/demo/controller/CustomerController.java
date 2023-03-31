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

import com.manager.demo.entity.Customer;
import com.manager.demo.entity.CustomerMedicine;
import com.manager.demo.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository cusRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllCustomer")
	public List<Customer> getAllCustomer() {
		List<Customer> cus = cusRepo.findAll();
		System.out.println("Get list of all Customer successfully");
		return cus;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertCustomer")
	public String insertCustomer(@RequestBody Customer obj) {
		System.out.println("Received data : " + obj);
		cusRepo.save(obj);
		return "Record Inserted Successfully";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateCustomer")
	public String updateCustomer(@RequestBody Customer obj) {
		Optional<Customer> cus = cusRepo.findById(obj.getId());
		
		if(cus.isPresent()) {
			Customer cusUpd = cus.get();
			cusUpd.setFirstName(obj.getFirstName());
			cusUpd.setLastName(obj.getLastName());
			cusUpd.setContact(obj.getContact());
			cusUpd.setEmail(obj.getEmail());
			cusUpd.setMedicine(obj.getMedicine());
			cusUpd.setDob(obj.getDob());
			cusUpd.setCreated_by(obj.getCreated_by());
			cusUpd.setModified_by(obj.getModified_by());
			cusUpd.setCreated_ts(obj.getCreated_ts());
			cusUpd.setModified_ts(obj.getModified_ts());
			System.out.println("Received Data in PutMapping :" + obj);
			cusRepo.save(obj);
			return "Record Updated Successfully";
		}
		else {
			return "Unable to update the record";
		}
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		System.out.println("Customer record deleted. Given id : " + id);
		cusRepo.deleteById(id);
		return "Record Deleted Successfully";
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getMedicineWithCustomer")
	public List<CustomerMedicine> getMedicineWithCustomer() {
		List<CustomerMedicine> cus = cusRepo.getMedicineWithCustomer();
		System.out.println("Get list of all CustomerMedicine successfully");
		return cus;
	}
}
