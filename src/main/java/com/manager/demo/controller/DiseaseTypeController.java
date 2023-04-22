package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manager.demo.entity.DiseaseType;
import com.manager.demo.repository.DiseaseTypeRepository;


/**
* This class represents a REST controller for Disease_Type entity.
* It provides endpoints to perform CRUD operations on Disease_Type.
*/
@RestController
public class DiseaseTypeController {
	@Autowired
	DiseaseTypeRepository disTypeRepo;

	/**
	 * Retrieves all the records of disease_type.
	 * @return List of Disease_Type records.
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllDiseaseType")
	public List<DiseaseType> getAllDiseaseType() {
		return disTypeRepo.findAll();
//		System.out.println("Get list of all disease_type successfully");
//		return disTy;
	}

	/**
	 * Inserts a new record of disease_type.
	 * @param obj Disease_Type object representing the new record.
	 * @return String indicating success or failure message.
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertDiseaseType")
	public DiseaseType insertManufacturer(@Valid @RequestBody DiseaseType obj) {
		System.out.println("Received data : " + obj);
		return disTypeRepo.save(obj);
//		return "Record Inserted Successfully";
	}

	/**
	 * Updates an existing record of disease_type.
	 * @param obj Disease_Type object representing the updated record.
	 * @return String indicating success or failure message.
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateDiseaseType")
	public DiseaseType updateDiseaseType(@RequestBody DiseaseType obj) throws ChangeSetPersister.NotFoundException {
		Optional<DiseaseType> disTy = disTypeRepo.findById(obj.getId());

		if (!disTy.isPresent()) {
			throw new ChangeSetPersister.NotFoundException();
		}
			DiseaseType disTyUpd = disTy.get();
			disTyUpd.setType(obj.getType());
			disTyUpd.setMedicine(obj.getMedicine());
		disTyUpd.setCreatedBy(obj.getCreatedBy());
		disTyUpd.setModifiedBy(obj.getModifiedBy());
		disTyUpd.setCreatedTimestamp(obj.getCreatedTimestamp());
		disTyUpd.setModifiedTimestamp(obj.getModifiedTimestamp());
			System.out.println("Received Data in PutMapping :" + obj);
			return disTypeRepo.save(obj);
	}

	/**
	 * Deletes an existing record of disease_type.
	 * @param id int representing the ID of the record to be deleted.
	 * @return String indicating success or failure message.
	 */
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteDiseaseType/{id}")
	public String deleteManufacturer(@PathVariable int id) {
		System.out.println("Disease_type record deleted. Given id : " + id);
		disTypeRepo.deleteById(id);
		return "Record Deleted Successfully";
	}
}
