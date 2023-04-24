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
import jakarta.validation.constraints.*;
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
	int saleId;
	@NotNull(message = "Sale Date is Mandatory")
	@Past(message = "Sale Date must be in the past and date format")
	Date saleDate;

	@NotNull(message = "Customer details is Mandatory")
	@Size(min = 1, max = 12, message = "List must contain between 1 and 12 elements")
	@OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "sales_fk", referencedColumnName = "saleId")
	List<Customer> customer;

	@NotNull(message = "Total Cost is Mandatory")
	@Positive(message = "Value must be greater than 0")
	@Digits(integer = 4, fraction = 2, message = "The field must be a number with up to 4 digits before and 2 digits after the decimal point")
	BigDecimal totalCost;
	
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
	 * @param totalCost The total cost of the sales.
	 */
	public Sales(int id, Date date, List<Customer> customer, BigDecimal totalCost) {
		super();
		this.saleId = id;
		this.saleDate = date;
		this.customer = customer;
		this.totalCost = totalCost;
	}

	/**
	 * Get the sales id.
	 * @return The sales id.
	 */
	public int getId() {
		return saleId;
	}

	/**
	 * Set the sales id.
	 * @param id The sales id.
	 */
	public void setId(int id) {
		this.saleId = id;
	}

	/**
	 * Get the date of the sales.
	 * @return The date of the sales.
	 */
	public Date getSaleDate() {
		return saleDate;
	}

	/**
	 * Set the date of the sales.
	 * @param date The date of the sales.
	 */
	public void setSaleDate(Date date) {
		this.saleDate = date;
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
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	/**
	 * Set the total cost of the sales.
	 * @param totalCost The total cost of the sales.
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * Get the string representation of this Sales entity.
	 * @return the string representation of this Sales entity.
	 */
	@Override
	public String toString() {
	    return "Sales [saleId=" + saleId + ", saleDate=" + saleDate + ", customer=" + customer + ", totalCost=" + totalCost
	            + "]";
	}
}
