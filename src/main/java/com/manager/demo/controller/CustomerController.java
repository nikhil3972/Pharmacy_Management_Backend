
package com.manager.demo.controller;

import java.util.List;
import java.util.Optional;

import com.manager.demo.dao.CustomerMedicineDao;
import com.manager.demo.dao.customerDao;
import com.manager.demo.service.CustomerService;
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

import com.manager.demo.entity.Customer;
import com.manager.demo.entity.CustomerMedicine;
import com.manager.demo.repository.CustomerRepository;


/**
 * The CustomerController class is a REST controller that handles HTTP requests related to the Customer entity in the Pharmacy Management System.
 */
@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private customerDao dao;
	@Autowired
	private CustomerMedicineDao cmDao;


	/**
	 * Retrieves a list of all customers from the CustomerRepository.
	 * @return A list of Customer entities.
	 */
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getAllCustomer")
	public List<Customer> getAllCustomer() {
		return customerService.getCustomer();
	}
	
	/**
	 * Inserts a new customer into the CustomerRepository.
	 * @param obj The Customer entity to be inserted.
	 * @return the saved Customer object.
	 */
	@CrossOrigin("http://localhost:4200")
	@PostMapping(path="/insertCustomer")
	public String insertCustomer(@Valid @RequestBody Customer obj) {
		System.out.println("Received data : " + obj);
		return customerService.addCustomer(obj);
	}
	
	/**
	 * Updates an existing Customer record in the database.
	 * @param obj the Customer object to be updated, containing new values
	 * @return the updated Customer object after saving to the database
	 * @throws ChangeSetPersister.NotFoundException if the customer with the specified ID does not exist in the database
	 * @throws Exception if there is an error while updating the customer record in the database
	 */
	@CrossOrigin("http://localhost:4200")
	@PutMapping(path="/updateCustomer")
	public String updateCustomer(@Valid @RequestBody Customer obj) throws Exception {
		Optional<Customer> cus = dao.findById(obj.getId());

		if (!cus.isPresent()) {
			throw new ChangeSetPersister.NotFoundException();
		}
			Customer cusUpd = cus.get();
			cusUpd.setFirstName(obj.getFirstName());
			cusUpd.setLastName(obj.getLastName());
			cusUpd.setContact(obj.getContact());
			cusUpd.setEmail(obj.getEmail());
			cusUpd.setMedicine(obj.getMedicine());
			cusUpd.setDob(obj.getDob());
			return customerService.updateCustomer(obj);

	}
	
	/**
	 * Deletes a customer from the CustomerRepository based on the provided id.
	 * @param id The id of the customer to be deleted.
	 * @return A string confirming that the record was successfully deleted.
	 */
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping (path="/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		System.out.println("Customer record deleted. Given id : " + id);
		customerService.deleteCustomer(id);
		return "Record Deleted Successfully";
	}
	
	/**
	 * Retrieves a list of CustomerMedicine entities from the CustomerRepository.
	 * @return A list of CustomerMedicine object containing the details of Customers along with the Medicines they have purchased.
	*/
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getMedicineWithCustomer")
	public List<CustomerMedicine> getMedicineWithCustomer() {
	List<CustomerMedicine> cus = customerRepo.getMedicineWithCustomer();
	System.out.println("Get list of all CustomerMedicine successfully");
	return cus;
	}
}
