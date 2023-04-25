package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

import com.manager.demo.dao.CustomerMedicineDao;
import com.manager.demo.service.MedicineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Sort;
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
	private MedicineService mService;
	private CustomerMedicineDao dao;
	
	/**
	 * Returns a list of all medicines.
	 * @return a list of all medicines
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllMedicine")
	public List<Medicine> getAllMedicine() {
		return mService.getMedicine() ;
	}
	
	/**
	 * Inserts a new medicine record into the database.
	 * @param obj the Medicine object to be inserted
	 * @return a message indicating the success or failure of the operation
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertMedicine")
	public String insertMedicine(@Valid @RequestBody Medicine obj) {
		System.out.println("Received data : " + obj);
		return mService.addMedicine(obj);
//		return "Record Inserted Successfully";
	}
	
	/**
	 * Updates an existing medicine record in the database.
	 * @param obj the Medicine object containing the updated data
	 * @return a message indicating the success or failure of the
	 * @throws NotFoundException if the medicine with the given ID is not found in the database.
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping (path="/updateMedicine")
	public String updateData(@Valid @RequestBody Medicine obj) throws NotFoundException {
		Optional<Medicine> med = dao.findById(obj.getId());

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
		System.out.println("Received Data in PutMapping :" + obj);
		return mService.updateMedicine(medUpd);

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
		mService.deleteMedicine(id);
		return "Record Deleted Successfully";
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllMedicineSorted")
	public List<Medicine> getMedicineInSortedOrder(){
		Sort sort = Sort.by(Sort.Direction.ASC, "medicineName").and(Sort.by(Sort.Direction.ASC, "description")).and(Sort.by(Sort.Direction.ASC, "dosage")).and(Sort.by(Sort.Direction.ASC, "price")).and(Sort.by(Sort.Direction.ASC, "currentStock"));
		return dao.findAll(sort);
	}
}
