package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

import com.manager.demo.dao.ManufacturerDao;
import com.manager.demo.service.ManufacturerService;
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

import com.manager.demo.entity.Manufacturer;
import com.manager.demo.repository.ManufacturerRepository;


/**
* This class is the controller for the Manufacturer entity. It handles all the HTTP requests related to the Manufacturer.
* It uses the ManufacturerRepository interface to perform CRUD operations on the database.
* The @RestController annotation is used to indicate that this class is a Spring MVC controller and should be used to handle incoming HTTP requests.
* The @Autowired annotation is used to auto wire the ManufacturerRepository interface to the controller class.
* The @CrossOrigin annotation is used to allow cross-origin requests from a specific domain.
*/

@RestController
public class ManufacturerController {
	@Autowired
	private ManufacturerService manufacturerService;
	@Autowired
	private ManufacturerDao dao;
	private ManufacturerRepository manRepo;



	/**
	 * This method retrieves all the records of Manufacturer from the database.
	 * 
	 * @return a List of Manufacturer objects.
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllManufacturer")
	public List<Manufacturer> getAllManufacturer() {
		return manufacturerService.getManufacturer();
//		System.out.println("Get list of all manufacturer successfully");
//		return med;
	}

	/**
	 * This method inserts a new Manufacturer record into the database.
	 * @param obj - A Manufacturer object containing the details of the new record to be inserted.
	 * @return a String indicating the success or failure of the operation.
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertManufacturer")
	public String insertManufacturer(@Valid @RequestBody Manufacturer obj) {
		System.out.println("Received data : " + obj);
		return manufacturerService.addManufacturer(obj);
//		return "Record Inserted Successfully";
	}

	/**
	 * This method updates an existing Manufacturer record in the database.
	 * @param obj - A Manufacturer object containing the details of the record to be updated.
	 * @return a String indicating the success or failure of the operation.
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateManufacturer")
	public String updateManufacturer(@Valid @RequestBody Manufacturer obj) throws ChangeSetPersister.NotFoundException {
		Optional<Manufacturer> man = dao.findById(obj.getId());

		if (!man.isPresent()) {
			throw new ChangeSetPersister.NotFoundException();
		}
			Manufacturer manUpd = man.get();
			manUpd.setManufacturerName(obj.getManufacturerName());
		manUpd.setDelivaryDate(obj.getDelivaryDate());
		manUpd.setQuantity(obj.getQuantity());
		manUpd.setMedicineName(obj.getMedicineName());
		manUpd.setTotalBill(obj.getTotalBill());
			System.out.println("Received Data in PutMapping :" + obj);
			return manufacturerService.updateManufacturer(manUpd);
	}

	/**
	 * This method deletes an existing Manufacturer record from the database.
	 * @param id - An integer representing the id of the record to be deleted.
	 * @return a String indicating the success or failure of the operation.
	 */
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteManufacturer/{id}")
	public String deleteManufacturer(@PathVariable int id) {
		System.out.println("Manufacturer record deleted. Given id : " + id);
		manufacturerService.deleteManufacturer(id);
		return "Record Deleted Successfully";
	}
}
