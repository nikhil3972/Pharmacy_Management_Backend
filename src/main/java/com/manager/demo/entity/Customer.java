package com.manager.demo.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

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
	String firstName;

	@NotBlank(message = "LastName is Mandatory")
	String lastName;

	@NotBlank(message = "Contact is Mandatory")
	String contact;

	@NotBlank(message = "Email is Mandatory")
	String email;

	@NotNull(message = "Medicine details is Mandatory")
	@OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_fk", referencedColumnName = "customerId")
	List<Medicine> medicine;

	@NotNull(message = "Date of Birth is Mandatory")
	Date dob;

	String createdBy;
	String modifiedBy;
	Date createdTimestamp;
	Date modifiedTimestamp;
	
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
	 * @param createdBy The username of the user who created the customer record.
	 * @param modifiedBy The username of the user who last modified the customer record.
	 * @param createdTimestamp The timestamp for when the customer record was created.
	 * @param modifiedTimestamp The timestamp for when the customer record was last modified.
	 */
	public Customer(int customerId, String firstName, String lastName, String contact, String email, List<Medicine> medicine,
			Date dob, String createdBy, String modifiedBy, Date createdTimestamp, Date modifiedTimestamp) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.medicine = medicine;
		this.dob = dob;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdTimestamp = createdTimestamp;
		this.modifiedTimestamp = modifiedTimestamp;
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
	 * Getter method for database created by whom.
	 * @return The name of person who has create the database.
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Setter method for the database created.
	 * @param createdBy The contact information for the customer.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	/**
	 * Retrieves the username of the user who last modified this customer's details.
	 * @return The username of the user who last modified this customer's details.
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets the username of the user who last modified this customer's details.
	 * @param modifiedBy The username of the user who last modified this customer's details.
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Retrieves the timestamp when this customer was created.
	 * @return The timestamp when this customer was created.
	 */
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	/**
	 * Sets the timestamp when this customer was created.
	 * @param createdTimestamp The timestamp when this customer was created.
	 */
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	/**
	 * Retrieves the timestamp when this customer was last modified.
	 * @return The timestamp when this customer was last modified.
	 */
	public Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	/**
	 * Sets the timestamp when this customer was last modified.
	 * @param modifiedTimestamp The timestamp when this customer was last modified.
	 */
	public void setModifiedTimestamp(Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}

	/**
	 * Returns a string representation of this customer, including all of their details.
	 * @return A string representation of this customer, including all of their details.
	 */
	@Override
	public String toString() {
		return "Customer [id=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ ", email=" + email + ", medicine=" + medicine + ", dob=" + dob + ", created_by=" + createdBy
				+ ", modified_by=" + modifiedBy + ", created_ts=" + createdTimestamp + ", modified_ts=" + modifiedTimestamp + "]";
	}	
}
