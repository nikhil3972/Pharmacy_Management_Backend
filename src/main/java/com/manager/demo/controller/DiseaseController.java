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

import com.manager.demo.entity.Disease;
import com.manager.demo.repository.DiseaseRepository;


/**
* This class is the controller for handling HTTP requests related to Disease entity.
* It contains methods for retrieving, inserting, updating and deleting Disease records.
* The responses are returned in JSON format.
* @author [Author Name]
* @version 1.0
* @since [Date of creation]
*/
@RestController
public class DiseaseController {
	@Autowired
	DiseaseRepository disRepo;

	/**
	 * Retrieves all the records from the 'Disease' table.
	 * @return List<Disease> List of all the Disease records
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllDisease")
	public List<Disease> getAllDisease() {
		return disRepo.findAll();
	}

	/**
	 * Inserts a new record into the 'Disease' table.
	 * @param obj Disease object to be inserted
	 * @return the saved Disease object
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertDisease")
	public Disease insertDisease(@Valid @RequestBody Disease obj) {
		System.out.println("Received data : " + obj);
		return disRepo.save(obj);
	}

	/**
	 * This endpoint updates an existing Disease object in the database.
	 * @param obj The Disease object to be updated, passed in the request body
	 * @return The updated Disease object
	 * @throws ChangeSetPersister.NotFoundException If the Disease object to be updated is not found in the database
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateDisease")
	public Disease updateDisease(@Valid @RequestBody Disease obj) throws ChangeSetPersister.NotFoundException {
		Optional<Disease> dis = disRepo.findById(obj.getId());

		if (!dis.isPresent()) {
			throw new ChangeSetPersister.NotFoundException();
		}
			Disease disUpd = dis.get();
			disUpd.setDiseaseName(obj.getDiseaseName());
			disUpd.setDiseaseInfo(obj.getDiseaseInfo());
			disUpd.setDiseaseType(obj.getDiseaseType());
			System.out.println("Received Data in PutMapping :" + obj);
			return disRepo.save(obj);
	}

	/**
	 * Deletes a record from the 'Disease' table based on the given id.
	 * @param id id of the record to be deleted
	 * @return String status message
	 */
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteDisease/{id}")
	public String deleteDisease(@PathVariable int id) {
		System.out.println("Disease record deleted. Given id : " + id);
		disRepo.deleteById(id);
		return "Record Deleted Successfully";
	}

}