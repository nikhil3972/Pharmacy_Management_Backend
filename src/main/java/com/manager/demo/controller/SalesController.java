
    package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.manager.demo.entity.Sales;
import com.manager.demo.repository.SalesRepository;


/**
 * This class represents the controller for Sales management
*/
@RestController
public class SalesController {
	@Autowired
	SalesRepository saleRepo;

	/**
	 * Get a list of all Sales records
	 * @return List of Sales records
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllSales")
	public List<Sales> getAllSales() {
		return saleRepo.findAll();
//		System.out.println("Get list of all Sales successfully");
//		return sale;
	}

	/**
	 * Insert a new Sales record
	 * @param obj - Sales object to insert
	 * @return String message indicating if the record was inserted successfully
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertSales")
	public Sales insertSales(@RequestBody Sales obj) {
		System.out.println("Received data : " + obj);
		return saleRepo.save(obj);
//		return "Record Inserted Successfully";
	}

	/**
	 * Update an existing Sales record
	 * @param obj - Sales object to update
	 * @return String message indicating if the record was updated successfully or not
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateSales")
	public Sales updateSales(@RequestBody Sales obj) throws ChangeSetPersister.NotFoundException {
		Optional<Sales> sale = saleRepo.findById(obj.getId());

		if (!sale.isPresent()) {
			throw new ChangeSetPersister.NotFoundException();
		}

			Sales saleUpd = sale.get();
			saleUpd.setDate(obj.getDate());
			saleUpd.setCustomer(obj.getCustomer());
		saleUpd.setTotalCost(obj.getTotalCost());
		saleUpd.setCreatedBy(obj.getCreatedBy());
		saleUpd.setModifiedBy(obj.getModifiedBy());
		saleUpd.setCreatedTimestamp(obj.getCreatedTimestamp());
		saleUpd.setModifiedTimestamp(obj.getModifiedTimestamp());
			System.out.println("Received Data in PutMapping :" + obj);
			return saleRepo.save(obj);
	}

	/**
	 * Delete an existing Sales record by its id
	 * @param id - Id of the Sales record to delete
	 * @return String message indicating if the record was deleted successfully or not
	 */
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteSales/{id}")
	public String deleteSales(@PathVariable int id) {
		System.out.println("Sales record deleted. Given id : " + id);
		saleRepo.deleteById(id);
		return "Record Deleted Successfully";
	}

}