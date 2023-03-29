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

import com.manager.demo.entity.Disease;
import com.manager.demo.repository.DiseaseRepository;

@RestController
public class DiseaseController {
	
	@Autowired
	DiseaseRepository disRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllDisease")
	public List<Disease> getAllDisease() {
		List<Disease> dis = disRepo.findAll();
		System.out.println("Get list of all disease successfully");
		return dis;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertDisease")
	public String insertDisease(@RequestBody Disease obj) {
		System.out.println("Received data : " + obj);
		disRepo.save(obj);
		return "Record Inserted Successfully";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateDisease")
	public String updateDisease(@RequestBody Disease obj) {
		Optional<Disease> dis = disRepo.findById(obj.getId());
		
		if(dis.isPresent()) {
			Disease disUpd = dis.get();
			disUpd.setName(obj.getName());
			disUpd.setInfo(obj.getInfo());
			disUpd.setDisease_type(obj.getDisease_type());
			disUpd.setCreated_by(obj.getCreated_by());
			disUpd.setModified_by(obj.getModified_by());
			disUpd.setCreated_ts(obj.getCreated_ts());
			disUpd.setModified_ts(obj.getModified_ts());
			System.out.println("Received Data in PutMapping :" + obj);
			disRepo.save(obj);
			return "Record Updated Successfully";
		}
		else {
			return "Unable to update the record";
		}
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteDisease/{id}")
	public String deleteDisease(@PathVariable int id) {
		System.out.println("Disease record deleted. Given id : " + id);
		disRepo.deleteById(id);
		return "Record Deleted Successfully";
	}
}
