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

import com.manager.demo.entity.Admin;
import com.manager.demo.repository.AdminRepository;

@RestController
public class AdminController {

	@Autowired
	AdminRepository admRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAdmin")
	public List<Admin> getAdmin() {
		List<Admin> adm = admRepo.findAll();
		System.out.println("Get Admin details successfully");
		return adm;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertAdmin")
	public String insertAdmin(@RequestBody Admin obj) {
		System.out.println("Received data : " + obj);
		admRepo.save(obj);
		return "Record Inserted Successfully";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateAdmin")
	public String updateAdmin(@RequestBody Admin obj) {
		Optional<Admin> adm = admRepo.findById(obj.getId());
		
		if(adm.isPresent()) {
			Admin admUpd = adm.get();
			admUpd.setEmail(obj.getEmail());
			admUpd.setPassword(obj.getPassword());
			admUpd.setCreated_by(obj.getCreated_by());
			admUpd.setModified_by(obj.getModified_by());
			admUpd.setCreated_ts(obj.getCreated_ts());
			admUpd.setModified_ts(obj.getModified_ts());
			System.out.println("Received Data in PutMapping :" + obj);
			admRepo.save(obj);
			return "Record Updated Successfully";
		}
		else {
			return "Unable to update the record";
		}
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable int id) {
		System.out.println("Admin record deleted. Given id : " + id);
		admRepo.deleteById(id);
		return "Record Deleted Successfully";
	}
}
