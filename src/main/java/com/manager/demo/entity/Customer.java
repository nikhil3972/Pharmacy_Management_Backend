package com.manager.demo.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * The Customer class represents a customer entity in the system.
 * It includes information such as the customer's name, contact information, email, medicine prescriptions, 
 * date of birth, and timestamps for creation and modification.
 */
@Entity
@Table(name="Customer")
public class Customer {

	@Id
	// @GeneratedValue
	int id;
	String firstName;
	String lastName;
	String contact;
	String email;
	
	@OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_fk", referencedColumnName = "id")
	List<Medicine> medicine;
	
	Date dob;
	String created_by;
	String modified_by;
	Date created_ts;
	Date modified_ts;
	
	/**
	 * Default constructor for Customer class.
	 */
	Customer(){}

	/**
	 * Constructor for Customer class.
	 * @param id The unique identifier for the customer.
	 * @param firstName The first name of the customer.
	 * @param lastName The last name of the customer.
	 * @param contact The contact information for the customer.
	 * @param email The email address of the customer.
	 * @param medicine The list of medicine prescriptions associated with the customer.
	 * @param dob The date of birth for the customer.
	 * @param created_by The username of the user who created the customer record.
	 * @param modified_by The username of the user who last modified the customer record.
	 * @param created_ts The timestamp for when the customer record was created.
	 * @param modified_ts The timestamp for when the customer record was last modified.
	 */
	public Customer(int id, String firstName, String lastName, String contact, String email, List<Medicine> medicine,
			Date dob, String created_by, String modified_by, Date created_ts, Date modified_ts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.medicine = medicine;
		this.dob = dob;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_ts = created_ts;
		this.modified_ts = modified_ts;
	}

	/**
	 * Getter method for the customer's unique identifier.
	 * @return The unique identifier for the customer.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for the customer's unique identifier.
	 * @param id The unique identifier for the customer.
	 */
	public void setId(int id) {
		this.id = id;
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
	public String getCreated_by() {
		return created_by;
	}

	/**
	 * Setter method for the database created.
	 * @param created_by The contact information for the customer.
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	
	/**
	 * Retrieves the username of the user who last modified this customer's details.
	 * @return The username of the user who last modified this customer's details.
	 */
	public String getModified_by() {
		return modified_by;
	}

	/**
	 * Sets the username of the user who last modified this customer's details.
	 * @param modified_by The username of the user who last modified this customer's details.
	 */
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	/**
	 * Retrieves the timestamp when this customer was created.
	 * @return The timestamp when this customer was created.
	 */
	public Date getCreated_ts() {
		return created_ts;
	}

	/**
	 * Sets the timestamp when this customer was created.
	 * @param created_ts The timestamp when this customer was created.
	 */
	public void setCreated_ts(Date created_ts) {
		this.created_ts = created_ts;
	}

	/**
	 * Retrieves the timestamp when this customer was last modified.
	 * @return The timestamp when this customer was last modified.
	 */
	public Date getModified_ts() {
		return modified_ts;
	}

	/**
	 * Sets the timestamp when this customer was last modified.
	 * @param modified_ts The timestamp when this customer was last modified.
	 */
	public void setModified_ts(Date modified_ts) {
		this.modified_ts = modified_ts;
	}

	/**
	 * Returns a string representation of this customer, including all of their details.
	 * @return A string representation of this customer, including all of their details.
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ ", email=" + email + ", medicine=" + medicine + ", dob=" + dob + ", created_by=" + created_by
				+ ", modified_by=" + modified_by + ", created_ts=" + created_ts + ", modified_ts=" + modified_ts + "]";
	}	
}
