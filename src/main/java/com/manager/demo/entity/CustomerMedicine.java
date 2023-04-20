package com.manager.demo.entity;

import java.math.BigDecimal;

/**
 * A class representing a customer's purchase of medicine, including details about the customer and the medicine.
 */
public class CustomerMedicine {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private String name;
	private BigDecimal price;
	
	/**
	 * Constructs a new CustomerMedicine object with the specified details.
	 *
	 * @param id The ID of the customer's purchase.
	 * @param firstName The first name of the customer.
	 * @param lastName The last name of the customer.
	 * @param email The email address of the customer.
	 * @param contact The phone number of the customer.
	 * @param name The name of the medicine.
	 * @param price The price of the medicine.
	 */
	public CustomerMedicine(int id, String firstName, String lastName, String email, String contact, String name,
			BigDecimal price) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Constructs a new empty CustomerMedicine object.
	 */
	CustomerMedicine(){}
	
	/**
	 * Retrieves the ID of the customer's purchase.
	 * @return The ID of the customer's purchase.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the ID of the customer's purchase.
	 * @param id The ID of the customer's purchase.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Retrieves the first name of the customer.
	 * @return The first name of the customer.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name of the customer.
	 * @param firstName The first name of the customer.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Retrieves the last name of the customer.
	 * @return The last name of the customer.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name of the customer.
	 * @param lastName The last name of the customer.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Retrieves the email address of the customer.
	 * @return The email address of the customer.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email address of the customer.
	 * @param email The email address of the customer.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Retrieves the phone number of the customer.
	 * @return The phone number of the customer.
	 */
	public String getContact() {
		return contact;
	}
	
	/**
	 * Sets the phone number of the customer.
	 * @param contact The phone number of the customer.
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	/**
	 * Retrieves the name of the medicine purchased by the customer.
	 * @return The name of the medicine purchased by the customer.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the medicine purchased by the customer.
	 * @param name The name of the medicine purchased by the customer.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the price of the medicine.
	 * @return the price of the medicine
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the price of the medicine.
	 * @param price the price of the medicine to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	
}
