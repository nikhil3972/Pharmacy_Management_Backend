package com.manager.demo.controller;

import com.manager.demo.dao.CustomerMedicineDao;
import com.manager.demo.dao.OnlyCustomerDao;
import com.manager.demo.dao.customerDao;
import com.manager.demo.entity.Customer;
import com.manager.demo.entity.onlyCustomer;
import com.manager.demo.repository.CustomerRepository;
import com.manager.demo.service.CustomerService;
import com.manager.demo.service.OnlyCustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class OnlyCustomerController {


    @Autowired
    private OnlyCustomerService customerService;
    @Autowired
    private OnlyCustomerDao dao;



    /**
     * Retrieves a list of all customers from the CustomerRepository.
     * @return A list of Customer entities.
     */
    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="/getAllOnlyCustomer")
    public List<onlyCustomer> getAllCustomer() {
        return customerService.getCustomer();
    }

    /**
     * Inserts a new customer into the CustomerRepository.
     * @param obj The Customer entity to be inserted.
     * @return the saved Customer object.
     */
    @CrossOrigin("http://localhost:4200")
    @PostMapping(path="/insertOnlyCustomer")
    public String insertCustomer(@Valid @RequestBody onlyCustomer obj) {
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
    @PutMapping(path="/updateOnlyCustomer")
    public String updateOnlyCustomer(@Valid @RequestBody onlyCustomer obj) throws Exception {
        Optional<onlyCustomer> cus = dao.findById(obj.getId());

        if (!cus.isPresent()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        onlyCustomer cusUpd = cus.get();
        cusUpd.setFirstName(obj.getFirstName());
        cusUpd.setLastName(obj.getLastName());
        cusUpd.setContact(obj.getContact());

        cusUpd.setMedicineName(obj.getMedicineName());
       cusUpd.setPrice(obj.getPrice());
        return customerService.updateCustomer(obj);

    }

    /**
     * Deletes a customer from the CustomerRepository based on the provided id.
     * @param id The id of the customer to be deleted.
     * @return A string confirming that the record was successfully deleted.
     */
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping (path="/deleteOnlyCustomer/{id}")
    public String deleteOnlyCustomer(@PathVariable int id) {
        System.out.println("Customer record deleted. Given id : " + id);
        customerService.deleteCustomer(id);
        return "Record Deleted Successfully";
    }

}

