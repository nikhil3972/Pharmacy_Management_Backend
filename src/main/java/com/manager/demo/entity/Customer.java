package com.manager.demo.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;

/**
 * The Customer class represents a customer entity in the system.
 * It includes information such as the customer's name, contact information, email, medicine prescriptions, 
 * date of birth, and timestamps for creation and modification.
 */
@Entity
@Table(name="Customer")
@Builder
public class Customer {

	@Id
	@GeneratedValue
	int customerId;

	@NotBlank(message = "FirstName is Mandatory")
	@Size(min = 3, message = "FirstName should have at least 3 characters")
	@Size(max = 10, message = "FirstName should not have more than 10 characters")
	@Pattern(regexp = "^[^0-9]*$", message = "FirstName only contain character")
	String firstName;

	@NotBlank(message = "LastName is Mandatory")
	@Size(min = 3, message = "LastName should have at least 3 characters")
	@Size(max = 10, message = "LastName should not have more than 10 characters")
	@Pattern(regexp = "^[^0-9]*$", message = "LastName only contain character")
	String lastName;

	@NotBlank(message = "Contact is Mandatory")
	@Size(min = 7, message = "Contact should have at least 3 characters")
	@Size(max = 12, message = "Contact should not have more than 12 characters")
	@Pattern(regexp = "^[0-9]+$", message = "Contact must contain only integer")
	String contact;

	@NotBlank(message = "Email is Mandatory")
	@Email(message = "Email must have in their proper format")
	String email;

	@NotNull(message = "Medicine details is Mandatory")
	@Size(min = 1, max = 12, message = "List must contain between 1 and 12 elements")
	@OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_fk", referencedColumnName = "customerId")
	List<Medicine> medicine;

	@NotNull(message = "Date of Birth is Mandatory")
	@Past(message = "Date of birth must be in the past and date format")
	Date dob;
	
	/**
	 * Default constructor for Customer class.
	 */
	Customer(){}

	/**
	 * Constructor for Customer class.
	 * @param customerId The unique identifier for the customer.
	 * @param firstName The first name of the customer.
	 * @param lastName The last name of the customer.
	 * @param contact The contact information for the customer.
	 * @param email The email address of the customer.
	 * @param medicine The list of medicine prescriptions associated with the customer.
	 * @param dob The date of birth for the customer.
	 */
	public Customer(int customerId, String firstName, String lastName, String contact, String email, List<Medicine> medicine,
			Date dob) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.medicine = medicine;
		this.dob = dob;
	}

	/**
	 * Getter method for the customer's unique identifier.
	 * @return The unique identifier for the customer.
	 */
	public int getId() {
		return customerId;
	}

	/**
	 * Setter method for the customer's unique identifier.
	 * @param id The unique identifier for the customer.
	 */
	public void setId(int id) {
		this.customerId = id;
	}

	/**
	 * Getter method for the customer's first name.
	 * @return The first name of the customer.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method for the customer's first name.
	 * @param firstName The first name of the customer.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter method for the customer's last name.
	 * @return The last name of the customer.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter method for the customer's last name.
	 * @param lastName The last name of the customer.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter method for the customer's contact information.
	 * @return The contact information for the customer.
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * Setter method for the customer's contact information.
	 * @param contact The contact information for the customer.
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * Getter method for the customer's Email.
	 * @return email of the customer.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for the Email of customer.
	 * @param email The email of the customer.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter method for taking list of medicines.
	 * @return The list of the medicine.
	 */
	public List<Medicine> getMedicine() {
		return medicine;
	}

	/**
	 * Setter method for list medicines.
	 * @param medicine The list of medicines.
	 */
	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}

	/**
	 * Getter method for the customer's date of birth.
	 * @return The date of birth for the customer.
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Setter method for the customer's date of birth.
	 * @param dob The contact information for the customer.
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Returns a string representation of this customer, including all of their details.
	 * @return A string representation of this customer, including all of their details.
	 */
	@Override
	public String toString() {
		return "Customer [id=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ ", email=" + email + ", medicine=" + medicine + ", dob=" + dob + "]";
	}	
}
