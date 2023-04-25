package com.manager.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="Medicine")
@Builder
public class Medicine {
	@Id
	@GeneratedValue
	int medicineId;

	@NotBlank(message = "Medicine name is Mandatory")
	@Size(min = 3, message = "Medicine name should have at least 3 characters")
	@Size(max = 20, message = "Medicine name should not have more than 20 characters")
	String medicineName;

	@NotBlank(message = "Description is Mandatory")
	@Size(min = 3, message = "Description should have at least 3 characters")
	String description;

	@NotBlank(message = "Dosage is Mandatory")
	@Size(min = 3, message = "Dosage should have at least 3 characters")
	String dosage;

	@NotNull(message = "Price is Mandatory")
	@Positive(message = "Value must be greater than 0")
	@Digits(integer = 4, fraction = 2, message = "The field must be a number with up to 4 digits before and 2 digits after the decimal point")
	BigDecimal price;

	@NotNull(message = "Manufacture Date is Mandatory")
	@Past(message = "Manufacture Date must be in the past and date format")
	Date manufactureDate;

	@NotNull(message = "Expiry Date is Mandatory")
	@Future(message = "Expiry Date must be in the future and date format")
	Date expiryDate;

	@Range(min = 1, message= "Current Stock may not be empty or null")
	@Positive(message = "Value must be greater than 0")
	int currentStock;




	/**
	 * Default constructor for Medicine.
	 */
	public Medicine() {}

	/**
	 * Constructor for Medicine with specified parameters.
	 * @param medicineId The ID of the medicine.
	 * @param medicineName The name of the medicine.
	 * @param description The description of the medicine.
	 * @param dosage The dosage of the medicine.
	 * @param price The price of the medicine.
	 * @param manufactureDate The manufacture date of the medicine.
	 * @param expiryDate The expiry date of the medicine.
	 * @param currentStock The current stock of the medicine.
	 */
	public Medicine(int medicineId, String medicineName, String description, String dosage, BigDecimal price, Date manufactureDate,
					Date expiryDate, int currentStock) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.description = description;
		this.dosage = dosage;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.currentStock = currentStock;

	}


	/**

	 Retrieves the ID of the medicine.
	 @return The ID of the medicine.
	 */
	public int getId() {
		return medicineId;
	}

	/**
	 * Sets the ID of the medicine.
	 * @param medicineId The ID to set for the medicine.
	 */
	public void setId(int medicineId) {
		this.medicineId = medicineId;
	}

	/**
	 * Retrieves the name of the medicine.
	 * @return The name of the medicine.
	 */
	public String getMedicineName() {
		return medicineName;
	}

	/**
	 * Sets the name of the medicine.
	 * @param medicineName The name to set for the medicine.
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	/**
	 * Retrieves the description of the medicine.
	 * @return The description of the medicine.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the medicine.
	 * @param description The description to set for the medicine.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Retrieves the dosage instructions for the medicine.
	 * @return The dosage instructions for the medicine.
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * Sets the dosage instructions for the medicine.
	 * @param dosage The dosage instructions to set for the medicine.
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * Retrieves the price of the medicine.
	 * @return The price of the medicine.
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the price of the medicine.
	 * @param price The price to set for the medicine.
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Retrieves the manufacture date of the medicine.
	 * @return The manufacture date of the medicine.
	 */
	public Date getManufactureDate() {
		return manufactureDate;
	}

	/**
	 * Sets the manufacture date of the medicine.
	 * @param manufactureDate The manufacture date to set for the medicine.
	 */
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	/**
	 * Retrieves the expiry date of the medicine.
	 * @return The expiry date of the medicine.
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Sets the expiry date of the medicine.
	 * @param expiryDate The expiry date to set for the medicine.
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * Retrieves the current stock of the medicine.
	 * @return The current stock of the medicine.
	 */
	public int getCurrentStock() {
		return currentStock;
	}
	/**
	 * Sets the current stock of the medicine.
	 * @param currentStock The current stock to set for the medicine.
	 */
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	/**
	 * Returns a string representation of the Medicine object, including its medicine ID, medicine name,
	 * description, dosage, price, manufacture date, expiry date, and current stock.
	 * @return A string representation of the Medicine object.
	 */
	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", description=" + description + ", dosage=" + dosage
				+ ", price=" + price + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate
				+ ", currentStock=" + currentStock + "]";
	}
}
