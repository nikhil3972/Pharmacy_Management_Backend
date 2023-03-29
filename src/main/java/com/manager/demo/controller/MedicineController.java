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

import com.manager.demo.entity.Medicine;
import com.manager.demo.repository.MedicineRepository;

@RestController
public class MedicineController {
	
	@Autowired
	MedicineRepository medRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllMedicine")
	public List<Medicine> getAllMedicine() {
		List<Medicine> med = medRepo.findAll();
		System.out.println("Get list of all medicines successfully");
		return med;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertMedicine")
	public String insertMedicine(@RequestBody Medicine obj) {
		System.out.println("Received data : " + obj);
		medRepo.save(obj);
		return "Record Inserted Successfully";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping (path="/updateMedicine")
	public String updateData(@RequestBody Medicine obj) {
		Optional<Medicine> med = medRepo.findById(obj.getId());
		
		if(med.isPresent()) {
			Medicine medUpd = med.get();
			medUpd.setName(obj.getName());
			medUpd.setDescription(obj.getDescription());
			medUpd.setDosage(obj.getDosage());
			medUpd.setPrice(obj.getPrice());
			medUpd.setManufacture_date(obj.getManufacture_date());
			medUpd.setExpiry_date(obj.getExpiry_date());
			medUpd.setCurrent_stock(obj.getCurrent_stock());
			medUpd.setCreated_by(obj.getCreated_by());
			medUpd.setModified_by(obj.getModified_by());
			medUpd.setCreated_ts(obj.getCreated_ts());
			medUpd.setModified_ts(obj.getModified_ts());
			System.out.println("Received Data in PutMapping :" + obj);
			medRepo.save(obj);
			return "Record Updated Successfully";
		}
		else {
			return "Unable to update the record";
		}
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteMedicine/{id}")
	public String deleteMedicine(@PathVariable int id) {
		System.out.println("Medicine record deleted. Given id : " + id);
		medRepo.deleteById(id);
		return "Record Deleted Successfully";
	}


	
}
