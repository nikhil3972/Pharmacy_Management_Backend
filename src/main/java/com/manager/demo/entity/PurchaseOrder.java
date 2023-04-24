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
 * Purchase_Order entity representing a purchase order in the system.
 */
@Entity
@Table(name="Purchase_Order")
@Builder
public class PurchaseOrder {

	@Id
	@GeneratedValue
	int purchaseId;

	@NotNull(message = "Purchase Date is Mandatory")
	@Past(message = "Date of birth must be in the past and date format")
	Date purchaseDate;

	@NotNull(message = "Manufacturer Order details is Mandatory")
	@Size(min = 1, max = 12, message = "List must contain between 1 and 12 elements")
	@OneToMany(targetEntity = Manufacturer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "purchase_order_fk", referencedColumnName = "purchaseId")
	List<Manufacturer> manufacturer;

	@NotNull(message = "Expected Delivery Date is Mandatory")
	@Future(message = "Expected Delivery Date must be in the future and date format")
	Date expectedDeliveryDate;

	@NotNull(message = "Price is Mandatory")
	@Positive(message = "Value must be greater than 0")
	@Digits(integer = 4, fraction = 2, message = "The field must be a number with up to 4 digits before and 2 digits after the decimal point")
	BigDecimal totalCost;
	
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

	 */
	public PurchaseOrder(int id, Date date, List<Manufacturer> manufacturer, Date expectedDeliveryDate,
						 BigDecimal totalCost) {
		super();
		this.purchaseId = id;
		this.purchaseDate = date;
		this.manufacturer = manufacturer;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.totalCost = totalCost;
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
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * Sets the date of the purchase order.
	 * @param date the date to be set for the purchase order.
	 */
	public void setPurchaseDate(Date date) {
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
	 * Returns the string representation of this Purchase_Order entity.
	 * @return the string representation of this Purchase_Order entity.
	 */
	@Override
	public String toString() {
	    return "Purchase_Order [id=" + purchaseId + ", date=" + purchaseDate + ", manufacturer=" + manufacturer
	            + ", expectedDeliveryDate=" + expectedDeliveryDate + ", totalCost=" + totalCost + "]";
	}
}
