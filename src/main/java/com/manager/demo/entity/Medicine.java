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
	 * @param id The ID of the medicine.
	 * @param medicineName The name of the medicine.
	 * @param description The description of the medicine.
	 * @param dosage The dosage of the medicine.
	 * @param price The price of the medicine.
	 * @param manufactureDate The manufacture date of the medicine.
	 * @param expiryDate The expiry date of the medicine.
	 * @param currentStock The current stock of the medicine.
	 */
	public Medicine(int id, String medicineName, String description, String dosage, BigDecimal price, Date manufactureDate,
					Date expiryDate, int currentStock) {
		super();
		this.medicineId = id;
		this.medicineName = medicineName;
		this.description = description;
		this.dosage = dosage;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.currentStock = currentStock;

	}


	public int getId() {
		return medicineId;
	}
	public void setId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
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
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", description=" + description + ", dosage=" + dosage
				+ ", price=" + price + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate
				+ ", currentStock=" + currentStock + "]";
	}
}
