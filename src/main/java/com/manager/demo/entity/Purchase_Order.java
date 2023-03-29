package com.manager.demo.entity;

import java.math.BigDecimal;
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
@Table(name="Purchase_Order")
public class Purchase_Order {

	@Id
	@GeneratedValue
	int id;
	Date date;
	
	@OneToMany(targetEntity = Manufacturer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "purchase_order_fk", referencedColumnName = "id")
	List<Manufacturer> manufacturer;
	
	Date expected_delivery_date;
	BigDecimal total_cost;
	String created_by;
	String modified_by;
	Date created_ts;
	Date modified_ts;
	
	Purchase_Order(){}

	public Purchase_Order(int id, Date date, List<Manufacturer> manufacturer, Date expected_delivery_date,
			BigDecimal total_cost, String created_by, String modified_by, Date created_ts, Date modified_ts) {
		super();
		this.id = id;
		this.date = date;
		this.manufacturer = manufacturer;
		this.expected_delivery_date = expected_delivery_date;
		this.total_cost = total_cost;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Manufacturer> getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(List<Manufacturer> manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getExpected_delivery_date() {
		return expected_delivery_date;
	}

	public void setExpected_delivery_date(Date expected_delivery_date) {
		this.expected_delivery_date = expected_delivery_date;
	}

	public BigDecimal getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(BigDecimal total_cost) {
		this.total_cost = total_cost;
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
		return "Purchase_Order [id=" + id + ", date=" + date + ", manufacturer=" + manufacturer
				+ ", expected_delivery_date=" + expected_delivery_date + ", total_cost=" + total_cost + ", created_by="
				+ created_by + ", modified_by=" + modified_by + ", created_ts=" + created_ts + ", modified_ts="
				+ modified_ts + "]";
	}
}
