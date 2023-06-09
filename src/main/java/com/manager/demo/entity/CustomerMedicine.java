package com.manager.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

/**
 * A class representing a customer's purchase of medicine, including details about the customer and the medicine.
 */
public class CustomerMedicine {

	@Id
	@GeneratedValue
	private int customerMedicineId;

	@NotBlank(message = "FirstName is Mandatory")
	@Size(min = 3, message = "FirstName should have at least 3 characters")
	@Size(max = 10, message = "FirstName should not have more than 10 characters")
	@Pattern(regexp = "^[^0-9]*$", message = "FirstName only contain character")
	private String firstName;

	@NotBlank(message = "LastName name is Mandatory")
	@Size(min = 3, message = "LastName should have at least 3 characters")
	@Size(max = 10, message = "LastName should not have more than 10 characters")
	@Pattern(regexp = "^[^0-9]*$", message = "LastName only contain character")
	private String lastName;

	@NotBlank(message = "Email is Mandatory")
	@Email(message = "Email must have in their proper format")
	private String email;

	@NotBlank(message = "Contact is Mandatory")
	@Range(min = 7, max = 12, message = "Contact size is must between range of 7 & 12")
	@Pattern(regexp = "^[0-9]+$", message = "Contact must contain only integer")
	private String contact;

	@NotBlank(message = "Medicine name is Mandatory")
	@Size(min = 3, message = "Medicine name should have at least 3 characters")
	@Size(max = 20, message = "Medicine name should not have more than 20 characters")
	@Pattern(regexp = "^[^0-9]*$", message = "Medicine name only contain character")
	private String medicineName;

	@NotNull(message = "Price is Mandatory")
	@Positive(message = "Value must be greater than 0")
	@Digits(integer = 4, fraction = 2, message = "The field must be a number with up to 4 digits before and 2 digits after the decimal point")
	public BigDecimal price;
	
	/**
	 * Constructs a new CustomerMedicine object with the specified details.
	 *
	 * @param customerMedicineId The ID of the customer's purchase.
	 * @param firstName The first name of the customer.
	 * @param lastName The last name of the customer.
	 * @param email The email address of the customer.
	 * @param contact The phone number of the customer.
	 * @param medicineName The name of the medicine.
	 * @param price The price of the medicine.
	 */
	public CustomerMedicine(int customerMedicineId, String firstName, String lastName, String email, String contact, String medicineName,
			BigDecimal price) {
		super();
		this.customerMedicineId = customerMedicineId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.medicineName = medicineName;
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
		return customerMedicineId;
	}
	
	/**
	 * Sets the ID of the customer's purchase.
	 * @param customerMedicineId The ID of the customer's purchase.
	 */
	public void setId(int customerMedicineId) {
		this.customerMedicineId = customerMedicineId;
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
		return medicineName;
	}
	
	/**
	 * Sets the name of the medicine purchased by the customer.
	 * @param medicineName The name of the medicine purchased by the customer.
	 */
	public void setName(String medicineName) {
		this.medicineName = medicineName;
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
