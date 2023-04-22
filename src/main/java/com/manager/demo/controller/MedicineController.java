package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
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
	public Medicine insertMedicine(@Valid @RequestBody Medicine obj) {
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
	public Medicine updateData(@Valid @RequestBody Medicine obj) throws NotFoundException {
		Optional<Medicine> med = medRepo.findById(obj.getId());

		if (!med.isPresent()) {
			throw new ChangeSetPersister.NotFoundException();
		}

		Medicine medUpd = med.get();
		medUpd.setMedicineName(obj.getMedicineName());
		medUpd.setDescription(obj.getDescription());
		medUpd.setDosage(obj.getDosage());
		medUpd.setPrice(obj.getPrice());
		medUpd.setManufactureDate(obj.getManufactureDate());
		medUpd.setExpiryDate(obj.getExpiryDate());
		medUpd.setCurrentStock(obj.getCurrentStock());
		medUpd.setCreatedBy(obj.getCreatedBy());
		medUpd.setModifiedBy(obj.getModifiedBy());
		medUpd.setCreatedTimestamp(obj.getCreatedTimestamp());
		medUpd.setModifiedTimestamp(obj.getModifiedTimestamp());
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
