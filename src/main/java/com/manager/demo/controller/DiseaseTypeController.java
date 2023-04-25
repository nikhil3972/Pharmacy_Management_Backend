package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

import com.manager.demo.dao.DiseasesTypeDao;
import com.manager.demo.service.DiseaseTypeService;
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
	private DiseaseTypeService dTService;
	private DiseasesTypeDao dao;

	/**
	 * Retrieves all the records of disease_type.
	 * @return List of Disease_Type records.
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllDiseaseType")
	public List<DiseaseType> getAllDiseaseType() {
		return dTService.getDiseaseType();
//		System.out.println("Get list of all disease_type successfully");
//		return disTy;
	}

	/**
	 * Inserts a new record of disease_type.
	 * @param obj Disease_Type object representing the new record.
	 * @return the saved DiseaseType object
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertDiseaseType")
	public String insertManufacturer(@Valid @RequestBody DiseaseType obj) {
		System.out.println("Received data : " + obj);
		return dTService.addDiseaseType(obj);
//		return "Record Inserted Successfully";
	}

	/**
	 * Updates an existing disease type record in the repository with the given DiseaseType object.
	 * @param obj the DiseaseType object containing the updated data for the disease type
	 * @return the updated DiseaseType object saved in the repository
	 * @throws ChangeSetPersister.NotFoundException if the disease type record to be updated is not found in the repository
	 * @throws IllegalArgumentException if the DiseaseType object is invalid or does not contain a valid ID
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateDiseaseType")
	public String updateDiseaseType(@Valid @RequestBody DiseaseType obj) throws ChangeSetPersister.NotFoundException {
		Optional<DiseaseType> disTy = dao.findById(obj.getId());

		if (!disTy.isPresent()) {
			throw new ChangeSetPersister.NotFoundException();
		}
			DiseaseType disTyUpd = disTy.get();
			disTyUpd.setType(obj.getType());
			disTyUpd.setMedicine(obj.getMedicine());
			System.out.println("Received Data in PutMapping :" + obj);
			return dTService.updateDiseaseType(disTyUpd);
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
		dTService.deleteDiseaseType(id);
		return "Record Deleted Successfully";
	}
}
