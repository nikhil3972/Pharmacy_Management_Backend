
    package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

import com.manager.demo.dao.SalesDao;
import com.manager.demo.service.SalesService;
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

import com.manager.demo.entity.Sales;
import com.manager.demo.repository.SalesRepository;


/**
 * This class represents the controller for Sales management
*/
@RestController
public class SalesController {
	@Autowired
	private SalesService saleService;

	private SalesDao saleDao;


	/**
	 * Get a list of all Sales records
	 * @return List of Sales records
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllSales")
	public List<Sales> getAllSales() {
		return saleService.getSale();
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
	public String insertSales(@Valid @RequestBody Sales obj) {
		System.out.println("Received data : " + obj);
		return saleService.addSales(obj);
//		return "Record Inserted Successfully";
	}

	/**
	 * Update an existing Sales record
	 * @param obj - Sales object to update
	 * @return String message indicating if the record was updated successfully or not
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateSales")
	public String updateSales(@Valid @RequestBody Sales obj) throws ChangeSetPersister.NotFoundException {
		Optional<Sales> sale = saleDao.findById(obj.getId());

		if (!sale.isPresent()) {
			throw new ChangeSetPersister.NotFoundException();
		}

			Sales saleUpd = sale.get();
			saleUpd.setSaleDate(obj.getSaleDate());
			saleUpd.setCustomer(obj.getCustomer());
		saleUpd.setTotalCost(obj.getTotalCost());
			System.out.println("Received Data in PutMapping :" + obj);
			return saleService.updateSales(obj);
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
		saleService.deleteSales(id);
		return "Record Deleted Successfully";
	}

}