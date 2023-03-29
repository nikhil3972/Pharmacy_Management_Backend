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

import com.manager.demo.entity.Manufacturer;
import com.manager.demo.repository.ManufacturerRepository;

@RestController
public class ManufacturerController {

	@Autowired
	ManufacturerRepository manRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllManufacturer")
	public List<Manufacturer> getAllManufacturer() {
		List<Manufacturer> med = manRepo.findAll();
		System.out.println("Get list of all manufacturer successfully");
		return med;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertManufacturer")
	public String insertManufacturer(@RequestBody Manufacturer obj) {
		System.out.println("Received data : " + obj);
		manRepo.save(obj);
		return "Record Inserted Successfully";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateManufacturer")
	public String updateManufacturer(@RequestBody Manufacturer obj) {
		Optional<Manufacturer> man = manRepo.findById(obj.getId());
		
		if(man.isPresent()) {
			Manufacturer manUpd = man.get();
			manUpd.setName(obj.getName());
			manUpd.setContact(obj.getContact());
			manUpd.setMedicine(obj.getMedicine());
			manUpd.setCreated_by(obj.getCreated_by());
			manUpd.setModified_by(obj.getModified_by());
			manUpd.setCreated_ts(obj.getCreated_ts());
			manUpd.setModified_ts(obj.getModified_ts());
			System.out.println("Received Data in PutMapping :" + obj);
			manRepo.save(obj);
			return "Record Updated Successfully";
		}
		else {
			return "Unable to update the record";
		}
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteManufacturer/{id}")
	public String deleteManufacturer(@PathVariable int id) {
		System.out.println("Manufacturer record deleted. Given id : " + id);
		manRepo.deleteById(id);
		return "Record Deleted Successfully";
	}
}
