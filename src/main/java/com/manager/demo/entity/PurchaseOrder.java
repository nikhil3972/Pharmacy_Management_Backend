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
 * Purchase_Order entity representing a purchase order in the system.
 */
@Entity
@Table(name="Purchase_Order")
@Builder
public class PurchaseOrder {

	@Id
	@GeneratedValue
	int purchaseId;
	Date purchaseDate;
	
	@OneToMany(targetEntity = Manufacturer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "purchase_order_fk", referencedColumnName = "purchaseId")
	List<Manufacturer> manufacturer;
	
	Date expectedDeliveryDate;
	BigDecimal totalCost;
	String createdBy;
	String modifiedBy;
	Date createdTimestamp;
	Date modifiedTimestamp;
	
	/**
	 * Default constructor for Purchase_Order.
	 */
	PurchaseOrder(){}

	/**
	 * Constructor for Purchase_Order with parameters.
	 * @param id the ID of the purchase order.
	 * @param date the date of the purchase order.
	 * @param manufacturer the list of manufacturers associated with the purchase order.
	 * @param expectedDeliveryDate the expected delivery date of the purchase order.
	 * @param totalCost the total cost of the purchase order.
	 * @param createdBy the user who created the purchase order.
	 * @param modifiedBy the user who last modified the purchase order.
	 * @param createdTimestamp the timestamp when the purchase order was created.
	 * @param modifiedTimestamp the timestamp when the purchase order was last modified.
	 */
	public PurchaseOrder(int id, Date date, List<Manufacturer> manufacturer, Date expectedDeliveryDate,
						 BigDecimal totalCost, String createdBy, String modifiedBy, Date createdTimestamp, Date modifiedTimestamp) {
		super();
		this.purchaseId = id;
		this.purchaseDate = date;
		this.manufacturer = manufacturer;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.totalCost = totalCost;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdTimestamp = createdTimestamp;
		this.modifiedTimestamp = modifiedTimestamp;
	}

	/**
	 * Returns the ID of the purchase order.
	 * @return the ID of the purchase order.
	 */
	public int getId() {
		return purchaseId;
	}

	/**
	 * Sets the ID of the purchase order.
	 * @param id the ID to be set for the purchase order.
	 */
	public void setId(int id) {
		this.purchaseId = id;
	}

	/**
	 * Returns the date of the purchase order.
	 * @return the date of the purchase order.
	 */
	public Date getDate() {
		return purchaseDate;
	}

	/**
	 * Sets the date of the purchase order.
	 * @param date the date to be set for the purchase order.
	 */
	public void setDate(Date date) {
		this.purchaseDate = date;
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
	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	/**
	 * Sets the expected delivery date of the purchase order.
	 * @param expectedDeliveryDate the expected delivery date to be set for the purchase order.
	 */
	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	/**
	 * Returns the total cost of the purchase order.
	 * @return the total cost of the purchase
	 */
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	/**
	 * Sets the total cost of this Purchase_Order entity.
	 * @param totalCost the total cost to be set for this Purchase_Order entity.
	 */
	public void setTotalCost(BigDecimal totalCost) {
	    this.totalCost = totalCost;
	}

	/**
	 * Returns the created by value of this Purchase_Order entity.
	 * @return the created by value of this Purchase_Order entity.
	 */
	public String getCreatedBy() {
	    return createdBy;
	}

	/**
	 * Sets the created by value of this Purchase_Order entity.
	 * @param createdBy the created by value to be set for this Purchase_Order entity.
	 */
	public void setCreatedBy(String createdBy) {
	    this.createdBy = createdBy;
	}

	/**
	 * Returns the modified by value of this Purchase_Order entity.
	 * @return the modified by value of this Purchase_Order entity.
	 */
	public String getModifiedBy() {
	    return modifiedBy;
	}

	/**
	 * Sets the modified by value of this Purchase_Order entity.
	 * @param modifiedBy the modified by value to be set for this Purchase_Order entity.
	 */
	public void setModifiedBy(String modifiedBy) {
	    this.modifiedBy = modifiedBy;
	}

	/**
	 * Returns the created timestamp of this Purchase_Order entity.
	 * @return the created timestamp of this Purchase_Order entity.
	 */
	public Date getCreatedTimestamp() {
	    return createdTimestamp;
	}

	/**
	 * Sets the created timestamp of this Purchase_Order entity.
	 * @param createdTimestamp the created timestamp to be set for this Purchase_Order entity.
	 */
	public void setCreatedTimestamp(Date createdTimestamp) {
	    this.createdTimestamp = createdTimestamp;
	}

	/**
	 * Returns the modified timestamp of this Purchase_Order entity.
	 * @return the modified timestamp of this Purchase_Order entity.
	 */
	public Date getModifiedTimestamp() {
	    return modifiedTimestamp;
	}

	/**
	 * Sets the modified timestamp of this Purchase_Order entity.
	 * @param modifiedTimestamp the modified timestamp to be set for this Purchase_Order entity.
	 */
	public void setModifiedTimestamp(Date modifiedTimestamp) {
	    this.modifiedTimestamp = modifiedTimestamp;
	}

	/**
	 * Returns the string representation of this Purchase_Order entity.
	 * @return the string representation of this Purchase_Order entity.
	 */
	@Override
	public String toString() {
	    return "Purchase_Order [id=" + purchaseId + ", date=" + purchaseDate + ", manufacturer=" + manufacturer
	            + ", expectedDeliveryDate=" + expectedDeliveryDate + ", totalCost=" + totalCost + ", createdBy="
	            + createdBy + ", modifiedBy=" + modifiedBy + ", createdTimestamp=" + createdTimestamp + ", modifiedTimestamp="
	            + modifiedTimestamp + "]";
	}
}
