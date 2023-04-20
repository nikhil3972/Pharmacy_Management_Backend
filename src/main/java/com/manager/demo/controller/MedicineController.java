package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

/**
 * The MedicineController class handles all the HTTP requests related to the Medicine entity.
 * It provides methods for getting, adding, updating, and deleting Medicine records.
 * The class is annotated with @RestController to indicate that it provides RESTful web services.
*/
@RestController
public class MedicineController {
	
	@Autowired
	MedicineRepository medRepo;
	
	/**
	 * Returns a list of all medicines.
	 * @return a list of all medicines
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllMedicine")
	public List<Medicine> getAllMedicine() {
		return medRepo.findAll();
//		System.out.println("Get list of all medicines successfully");
//		return med;
	}
	
	/**
	 * Inserts a new medicine record into the database.
	 * @param obj the Medicine object to be inserted
	 * @return a message indicating the success or failure of the operation
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertMedicine")
	public Medicine insertMedicine(@RequestBody Medicine obj) {
		System.out.println("Received data : " + obj);
		return medRepo.save(obj);
//		return "Record Inserted Successfully";
	}
	
	/**
	 * Updates an existing medicine record in the database.
	 * @param obj the Medicine object containing the updated data
	 * @return a message indicating the success or failure of the operation
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping (path="/updateMedicine")
	public Medicine updateData(@RequestBody Medicine obj) {
		Optional<Medicine> med = medRepo.findById(obj.getId());
		
//		if(!med.isPresent()) {
//
//			throw new NotFoundException("Medicine id " + obj.getId() + "does not exist");
////			return "Record Updated Successfully";
//		}

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
		return medRepo.save(obj);

	}
	
	/**
	 * Deletes a medicine record from the database.
	 * @param id the ID of the medicine record to be deleted
	 * @return a message indicating the success or failure of the operation
	 */
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteMedicine/{id}")
	public String deleteMedicine(@PathVariable int id) {
		System.out.println("Medicine record deleted. Given id : " + id);
		medRepo.deleteById(id);
		return "Record Deleted Successfully";
	}	
}
