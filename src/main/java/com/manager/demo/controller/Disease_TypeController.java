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

import com.manager.demo.entity.Disease_Type;
import com.manager.demo.repository.Disease_TypeRepository;

@RestController
public class Disease_TypeController {
	
	@Autowired
	Disease_TypeRepository disTypeRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllDisease_Type")
	public List<Disease_Type> getAllDiseaseType() {
		List<Disease_Type> disTy = disTypeRepo.findAll();
		System.out.println("Get list of all disease_type successfully");
		return disTy;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertDisease_Type")
	public String insertManufacturer(@RequestBody Disease_Type obj) {
		System.out.println("Received data : " + obj);
		disTypeRepo.save(obj);
		return "Record Inserted Successfully";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateDisease_Type")
	public String updateManufacturer(@RequestBody Disease_Type obj) {
		Optional<Disease_Type> disTy = disTypeRepo.findById(obj.getId());
		
		if(disTy.isPresent()) {
			Disease_Type disTyUpd = disTy.get();
			disTyUpd.setType(obj.getType());
			disTyUpd.setMedicine(obj.getMedicine());
			disTyUpd.setCreated_by(obj.getCreated_by());
			disTyUpd.setModified_by(obj.getModified_by());
			disTyUpd.setCreated_ts(obj.getCreated_ts());
			disTyUpd.setModified_ts(obj.getModified_ts());
			System.out.println("Received Data in PutMapping :" + obj);
			disTypeRepo.save(obj);
			return "Record Updated Successfully";
		}
		else {
			return "Unable to update the record";
		}
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteDisease_Type/{id}")
	public String deleteManufacturer(@PathVariable int id) {
		System.out.println("Disease_type record deleted. Given id : " + id);
		disTypeRepo.deleteById(id);
		return "Record Deleted Successfully";
	}
}
