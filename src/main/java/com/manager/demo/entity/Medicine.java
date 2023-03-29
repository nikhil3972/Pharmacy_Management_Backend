package com.manager.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Medicine")
public class Medicine {
	@Id
	@GeneratedValue
	int id;
	String name;
	String description;
	String dosage;
	BigDecimal price;
	Date manufacture_date;
	Date expiry_date;
	int current_stock;
	String created_by;
	String modified_by;
	Date created_ts;
	Date modified_ts;
	
	Medicine(){}
	public Medicine(int id, String name, String description, String dosage, BigDecimal price, Date manufacture_date,
			Date expiry_date, int current_stock, String created_by, String modified_by, Date created_ts,
			Date modified_ts) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dosage = dosage;
		this.price = price;
		this.manufacture_date = manufacture_date;
		this.expiry_date = expiry_date;
		this.current_stock = current_stock;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getManufacture_date() {
		return manufacture_date;
	}
	public void setManufacture_date(Date manufacture_date) {
		this.manufacture_date = manufacture_date;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public int getCurrent_stock() {
		return current_stock;
	}
	public void setCurrent_stock(int current_stock) {
		this.current_stock = current_stock;
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
		return "Medicine [id=" + id + ", name=" + name + ", description=" + description + ", dosage=" + dosage
				+ ", price=" + price + ", manufacture_date=" + manufacture_date + ", expiry_date=" + expiry_date
				+ ", current_stock=" + current_stock + ", created_by=" + created_by + ", modified_by=" + modified_by
				+ ", created_ts=" + created_ts + ", modified_ts=" + modified_ts + "]";
	}	
}
