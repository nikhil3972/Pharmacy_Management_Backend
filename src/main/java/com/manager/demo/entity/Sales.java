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
import lombok.Builder;


/**
 * This class represents a Sales entity which contains information about sales such as sales id, date, list of customers, total cost,
 * created by, modified by, created timestamp, and modified timestamp.
 */
@Entity
@Table(name="Sales")
@Builder
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
	
	/**
	 * Default constructor for Sales entity.
	 */
	Sales(){}

	/**
	 * Constructor with arguments for Sales entity.
	 * 
	 * @param id The id of the sales.
	 * @param date The date of the sales.
	 * @param customer The list of customers associated with the sales.
	 * @param total_cost The total cost of the sales.
	 * @param created_by The name of the user who created the sales.
	 * @param modified_by The name of the user who modified the sales.
	 * @param created_ts The timestamp when the sales was created.
	 * @param modified_ts The timestamp when the sales was last modified.
	 */
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

	/**
	 * Get the sales id.
	 * @return The sales id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the sales id.
	 * @param id The sales id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the date of the sales.
	 * @return The date of the sales.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set the date of the sales.
	 * @param date The date of the sales.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Get the list of customers associated with the sales.
	 * @return The list of customers associated with the sales.
	 */
	public List<Customer> getCustomer() {
		return customer;
	}

	/**
	 * Set the list of customers associated with the sales.
	 * @param customer The list of customers associated with the sales.
	 */
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	/**
	 * Get the total cost of the sales.
	 * @return The total cost of the sales.
	 */
	public BigDecimal getTotal_cost() {
		return total_cost;
	}

	/**
	 * Set the total cost of the sales.
	 * @param total_cost The total cost of the sales.
	 */
	public void setTotal_cost(BigDecimal total_cost) {
		this.total_cost = total_cost;
	}

	

	/**
	 * Get the created by value of this Sales entity.
	 * @return the created by value of this Sales entity.
	 */
	public String getCreated_by() {
	    return created_by;
	}

	/**
	 * Sets the created by value of this Sales entity.
	 * @param created_by the created by value to be set for this Sales entity.
	 */
	public void setCreated_by(String created_by) {
	    this.created_by = created_by;
	}

	/**
	 * Get the modified by value of this Sales entity.
	 * @return the modified by value of this Sales entity.
	 */
	public String getModified_by() {
	    return modified_by;
	}

	/**
	 * Sets the modified by value of this Sales entity.
	 * @param modified_by the modified by value to be set for this Sales entity.
	 */
	public void setModified_by(String modified_by) {
	    this.modified_by = modified_by;
	}

	/**
	 * Get the created timestamp of this Sales entity.
	 * @return the created timestamp of this Sales entity.
	 */
	public Date getCreated_ts() {
	    return created_ts;
	}

	/**
	 * Sets the created timestamp of this Sales entity.
	 * @param created_ts the created timestamp to be set for this Sales entity.
	 */
	public void setCreated_ts(Date created_ts) {
	    this.created_ts = created_ts;
	}

	/**
	 * Get the modified timestamp of this Sales entity.
	 * @return the modified timestamp of this Sales entity.
	 */
	public Date getModified_ts() {
	    return modified_ts;
	}

	/**
	 * Sets the modified timestamp of this Sales entity.
	 * @param modified_ts the modified timestamp to be set for this Sales entity.
	 */
	public void setModified_ts(Date modified_ts) {
	    this.modified_ts = modified_ts;
	}

	/**
	 * Get the string representation of this Sales entity.
	 * @return the string representation of this Sales entity.
	 */
	@Override
	public String toString() {
	    return "Sales [id=" + id + ", date=" + date + ", customer=" + customer + ", total_cost=" + total_cost
	            + ", created_by=" + created_by + ", modified_by=" + modified_by + ", created_ts=" + created_ts
	            + ", modified_ts=" + modified_ts + "]";
	}
}
