package com.manager.demo.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
//	@GeneratedValue
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
	
	Customer(){}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Medicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getCreated_ts() {
		return created_ts;
	}

	public void setCreated_ts(Date created_ts) {
		this.created_ts = created_ts;
	}

	public Date getModified_ts() {
		return modified_ts;
	}

	public void setModified_ts(Date modified_ts) {
		this.modified_ts = modified_ts;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ ", email=" + email + ", medicine=" + medicine + ", dob=" + dob + ", created_by=" + created_by
				+ ", modified_by=" + modified_by + ", created_ts=" + created_ts + ", modified_ts=" + modified_ts + "]";
	}	
}
