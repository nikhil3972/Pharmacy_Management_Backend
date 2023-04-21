package com.manager.demo.service;
import com.manager.demo.entity.*;
import java.util.*;
import java.util.concurrent.*;

public class CustomerService {

private int customerIdCount= 1;
private List<CustomerMedicine> customerList =new CopyOnWriteArrayList<>();
public  CustomerMedicine addCustomerMedicine(CustomerMedicine customer) {
	customer.setId(customerIdCount);
	customerList.add(customer);
	customerIdCount++;
	return customer;
}

public List<CustomerMedicine>getCustomer(){
	return customerList;
}
public 	CustomerMedicine getCustomer(int customerId) {
	return customerList.stream().filter(c -> c.getId()== customerId)
			.findFirst().get();
}
public CustomerMedicine updateCustomer(int customerId,	CustomerMedicine customer) {
	customerList.stream().forEach(c->{
		if(c.getId()== customerId) {
			c.setFirstName(customer.getFirstName());
			c.setLastName(customer.getLastName());
			c.setPrice(customer.getPrice());
			c.setContact(customer.getContact());
			c.setEmail(customer.getEmail());
		}
	});
	return customerList.stream().filter(c->c.getId()== customerId).findFirst().get();
}
public void deleteCustomerMedicine(int customerId) {
	customerList.stream().forEach(c->{
		if(c.getId()==customerId) {
			customerList.remove(c);
		}
	});
}
}
