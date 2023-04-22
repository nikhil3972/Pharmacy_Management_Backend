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

	@NotBlank(message = "Name is Mandatory")
	String medicineName;

	@NotBlank(message = "Description is Mandatory")
	String description;

	@NotBlank(message = "Dosage is Mandatory")
	String dosage;

	@NotNull(message = "Price is Mandatory")
	@Positive(message = "Value must be greater than 0")
	BigDecimal price;

	@NotNull(message = "Manufacture Date is Mandatory")
	Date manufactureDate;

	@NotNull(message = "Expiry Date is Mandatory")
	Date expiryDate;

	@Range(min = 1, message= "Current Stock may not be empty or null")
	@Positive(message = "Value must be greater than 0")
	int currentStock;

	String createdBy;
	String modifiedBy;
	Date createdTimestamp;
	Date modifiedTimestamp;


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
	 * @param createdBy The user who created the medicine.
	 * @param modifiedBy The user who last modified the medicine.
	 * @param createdTimestamp The timestamp when the medicine was created.
	 * @param modifiedTimestamp The timestamp when the medicine was last modified.
	 */
	public Medicine(int id, String medicineName, String description, String dosage, BigDecimal price, Date manufactureDate,
					Date expiryDate, int currentStock, String createdBy, String modifiedBy, Date createdTimestamp,
					Date modifiedTimestamp) {
		super();
		this.medicineId = id;
		this.medicineName = medicineName;
		this.description = description;
		this.dosage = dosage;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.currentStock = currentStock;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdTimestamp = createdTimestamp;
		this.modifiedTimestamp = modifiedTimestamp;
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}
	public void setModifiedTimestamp(Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", description=" + description + ", dosage=" + dosage
				+ ", price=" + price + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate
				+ ", currentStock=" + currentStock + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdTimestamp=" + createdTimestamp + ", modifiedTimestamp=" + modifiedTimestamp + "]";
	}
}
