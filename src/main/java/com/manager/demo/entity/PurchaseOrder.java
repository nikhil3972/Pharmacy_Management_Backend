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

/**
 * Purchase_Order entity representing a purchase order in the system.
 */
@Entity
@Table(name="Purchase_Order")
public class PurchaseOrder {

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
	
	/**
	 * Default constructor for Purchase_Order.
	 */
	PurchaseOrder(){}

	/**
	 * Constructor for Purchase_Order with parameters.
	 * @param id the ID of the purchase order.
	 * @param date the date of the purchase order.
	 * @param manufacturer the list of manufacturers associated with the purchase order.
	 * @param expected_delivery_date the expected delivery date of the purchase order.
	 * @param total_cost the total cost of the purchase order.
	 * @param created_by the user who created the purchase order.
	 * @param modified_by the user who last modified the purchase order.
	 * @param created_ts the timestamp when the purchase order was created.
	 * @param modified_ts the timestamp when the purchase order was last modified.
	 */
	public PurchaseOrder(int id, Date date, List<Manufacturer> manufacturer, Date expected_delivery_date,
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

	/**
	 * Returns the ID of the purchase order.
	 * @return the ID of the purchase order.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the purchase order.
	 * @param id the ID to be set for the purchase order.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the date of the purchase order.
	 * @return the date of the purchase order.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date of the purchase order.
	 * @param date the date to be set for the purchase order.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Returns the list of manufacturers associated with the purchase order.
	 * @return the list of manufacturers associated with the purchase order.
	 */
	public List<Manufacturer> getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets the list of manufacturers associated with the purchase order.
	 * @param manufacturer the list of manufacturers to be set for the purchase order.
	 */
	public void setManufacturer(List<Manufacturer> manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Returns the expected delivery date of the purchase order.
	 * @return the expected delivery date of the purchase order.
	 */
	public Date getExpected_delivery_date() {
		return expected_delivery_date;
	}

	/**
	 * Sets the expected delivery date of the purchase order.
	 * @param expected_delivery_date the expected delivery date to be set for the purchase order.
	 */
	public void setExpected_delivery_date(Date expected_delivery_date) {
		this.expected_delivery_date = expected_delivery_date;
	}

	/**
	 * Returns the total cost of the purchase order.
	 * @return the total cost of the purchase
	 */
	public BigDecimal getTotal_cost() {
		return total_cost;
	}

	/**
	 * Sets the total cost of this Purchase_Order entity.
	 * @param total_cost the total cost to be set for this Purchase_Order entity.
	 */
	public void setTotal_cost(BigDecimal total_cost) {
	    this.total_cost = total_cost;
	}

	/**
	 * Returns the created by value of this Purchase_Order entity.
	 * @return the created by value of this Purchase_Order entity.
	 */
	public String getCreated_by() {
	    return created_by;
	}

	/**
	 * Sets the created by value of this Purchase_Order entity.
	 * @param created_by the created by value to be set for this Purchase_Order entity.
	 */
	public void setCreated_by(String created_by) {
	    this.created_by = created_by;
	}

	/**
	 * Returns the modified by value of this Purchase_Order entity.
	 * @return the modified by value of this Purchase_Order entity.
	 */
	public String getModified_by() {
	    return modified_by;
	}

	/**
	 * Sets the modified by value of this Purchase_Order entity.
	 * @param modified_by the modified by value to be set for this Purchase_Order entity.
	 */
	public void setModified_by(String modified_by) {
	    this.modified_by = modified_by;
	}

	/**
	 * Returns the created timestamp of this Purchase_Order entity.
	 * @return the created timestamp of this Purchase_Order entity.
	 */
	public Date getCreated_ts() {
	    return created_ts;
	}

	/**
	 * Sets the created timestamp of this Purchase_Order entity.
	 * @param created_ts the created timestamp to be set for this Purchase_Order entity.
	 */
	public void setCreated_ts(Date created_ts) {
	    this.created_ts = created_ts;
	}

	/**
	 * Returns the modified timestamp of this Purchase_Order entity.
	 * @return the modified timestamp of this Purchase_Order entity.
	 */
	public Date getModified_ts() {
	    return modified_ts;
	}

	/**
	 * Sets the modified timestamp of this Purchase_Order entity.
	 * @param modified_ts the modified timestamp to be set for this Purchase_Order entity.
	 */
	public void setModified_ts(Date modified_ts) {
	    this.modified_ts = modified_ts;
	}

	/**
	 * Returns the string representation of this Purchase_Order entity.
	 * @return the string representation of this Purchase_Order entity.
	 */
	@Override
	public String toString() {
	    return "Purchase_Order [id=" + id + ", date=" + date + ", manufacturer=" + manufacturer
	            + ", expected_delivery_date=" + expected_delivery_date + ", total_cost=" + total_cost + ", created_by="
	            + created_by + ", modified_by=" + modified_by + ", created_ts=" + created_ts + ", modified_ts="
	            + modified_ts + "]";
	}
}
