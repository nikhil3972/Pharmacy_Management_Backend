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
@Table(name="Disease_Type")
public class Disease_Type {
	
	@Id
	@GeneratedValue
	int id;
	String type;
	
	@OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "disease_type_fk", referencedColumnName = "id")
	List<Medicine> medicine;
	
	String created_by;
	String modified_by;
	Date created_ts;
	Date modified_ts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		return "Disease_Type [id=" + id + ", type=" + type + ", medicine=" + medicine + ", created_by=" + created_by
				+ ", modified_by=" + modified_by + ", created_ts=" + created_ts + ", modified_ts=" + modified_ts + "]";
	}	
}
