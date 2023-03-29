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
@Table(name="Sales")
public class Sales {

	@Id
	@GeneratedValue
	int id;
	String date;
	
	@OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "sales_fk", referencedColumnName = "id")
	List<Customer> customer;
	
	BigDecimal total_cost;
	String created_by;
	String modified_by;
	Date created_ts;
	Date modified_ts;
	
	Sales(){}

	public Sales(int id, String date, List<Customer> customer, BigDecimal total_cost, String created_by,
			String modified_by, Date created_ts, Date modified_ts) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
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
		return "Sales [id=" + id + ", date=" + date + ", customer=" + customer + ", total_cost=" + total_cost
				+ ", created_by=" + created_by + ", modified_by=" + modified_by + ", created_ts=" + created_ts
				+ ", modified_ts=" + modified_ts + "]";
	}
}
