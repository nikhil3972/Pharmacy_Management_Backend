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
@Table(name="Manufacturer")
public class Manufacturer {
	@Id
	@GeneratedValue
	int id;
	String name;
	String contact;
	
	@OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "manu_fk", referencedColumnName = "id")
	List<Medicine> medicine;
	
	String created_by;
	String modified_by;
	Date created_ts;
	Date modified_ts;
	
	Manufacturer(){}

	public Manufacturer(int id, String name, String contact, List<Medicine> medicine, String created_by, String modified_by, Date created_ts, Date modified_ts) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.medicine = medicine;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Medicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
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
		return "Manufacturer [id=" + id + ", name=" + name + ", contact=" + contact + ", medicine=" + medicine
				+ ", created_by=" + created_by + ", modified_by=" + modified_by + ", created_ts=" + created_ts
				+ ", modified_ts=" + modified_ts + "]";
	}
}
