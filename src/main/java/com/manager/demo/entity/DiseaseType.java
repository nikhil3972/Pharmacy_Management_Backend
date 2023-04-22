package com.manager.demo.entity;

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
 * This class represents a Disease Type entity, which is mapped to the "Disease_Type" table in the database.
 * It contains fields for the ID, type, list of medicines, created by, modified by, created timestamp and modified timestamp.
 */
@Entity
@Table(name="Disease_Type")
@Builder
public class DiseaseType {
	
	/**
	 * The ID of the disease type.
	 */
	@Id
	@GeneratedValue
	int diseaseTypeId;
	
	/**
	 * The type of the disease.
	 */
	@NotBlank(message = "Disease Type is Mandatory")
	@Size(min = 3, message = "Disease Type should have at least 3 characters")
	@Size(max = 20, message = "Disease Type should not have more than 20 characters")
	String type;
	
	/**
	 * The list of medicines associated with the disease type.
	 */
	@NotNull(message = "Disease Type details is Mandatory")
	@Size(min = 1, max = 12, message = "List must contain between 1 and 12 elements")
	@OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "disease_type_fk", referencedColumnName = "diseaseTypeId")
	List<Medicine> medicine;

	@NotBlank(message = "CreatedBy is Mandatory")
	@Size(min = 3, message = "CreatedBy should have at least 3 characters")
	@Size(max = 10, message = "CreatedBy should not have more than 10 characters")
	@Pattern(regexp = "^[^0-9]*$", message = "CreatedBy only contain character")
	String createdBy;

	@NotBlank(message = "ModifiedBy is Mandatory")
	@Size(min = 3, message = "ModifiedBy should have at least 3 characters")
	@Size(max = 10, message = "ModifiedBy should not have more than 10 characters")
	@Pattern(regexp = "^[^0-9]*$", message = "ModifiedBy only contain character")
	String modifiedBy;

	@NotNull(message = "CreatedTimestamp is Mandatory")
	@Past(message = "CreatedTimestamp must be in the past and date format")
	Date createdTimestamp;

	@NotNull(message = "ModifiedTimestamp is Mandatory")
	@Past(message = "ModifiedTimestamp must be in the past and date format")
	Date modifiedTimestamp;

	/**
	 * Default constructor for DiseaseType.
	 */
	public DiseaseType() {}

	/**
	 * Constructor for DiseaseType with specified parameters.
	 * @param diseaseTypeId The ID of the disease type.
	 * @param type The type of the disease.
	 * @param medicine The list of medicines associated with the disease type.
	 * @param createdBy The user who created the disease type.
	 * @param modifiedBy The user who last modified the disease type.
	 * @param createdTimestamp The timestamp when the disease type was created.
	 * @param modifiedTimestamp The timestamp when the disease type was last modified.
	 */
	public DiseaseType(int diseaseTypeId, String type, List<Medicine> medicine, String createdBy, String modifiedBy, Date createdTimestamp, Date modifiedTimestamp){
		super();
		this.diseaseTypeId = diseaseTypeId;
		this.type = type;
		this.medicine = medicine;
		this.createdBy = createdBy;
		this.modifiedBy = DiseaseType.this.modifiedBy;
		this.createdTimestamp = createdTimestamp;
		this.modifiedTimestamp = modifiedTimestamp;
	}

	/**
	 * Gets the ID of the disease type.
	 * @return The ID of the disease type.
	 */
	public int getId() {
		return diseaseTypeId;
	}
	
	/**
	 * Sets the ID of the disease type.
	 * @param id The ID of the disease type.
	 */
	public void setId(int id) {
		this.diseaseTypeId = id;
	}
	
	/**
	 * Gets the type of the disease.
	 * @return The type of the disease.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type of the disease.
	 * @param type The type of the disease.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the list of medicines associated with the disease type.
	 * @return The list of medicines associated with the disease type.
	 */
	public List<Medicine> getMedicine() {
		return medicine;
	}
	
	/**
	 * Sets the list of medicines associated with the disease type.
	 * @param medicine The list of medicines associated with the disease type.
	 */
	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}
	
	/**
	 * Gets the name of the user who created the disease type record.
	 * @return The name of the user who created the disease type record.
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * Sets the name of the user who created the disease type record.
	 * @param createdBy The name of the user who created the disease type record.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * Gets the name of the user who last modified the disease type record.
	 * @return The name of the user who last modified the disease type record.
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}
	
	/**
	 * Sets the name of the user who last modified the disease type record.
	 * @param modifiedBy The name of the user who last modified the disease type record.
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = DiseaseType.this.modifiedBy;
	}
	
	/**
	 * Gets the timestamp when the disease type record was created.
	 * @return The timestamp when the disease type record was created.
	 */
	/** 
	 * Returns the created timestamp of this Disease_Type entity.
	 * @return the created timestamp of this Disease_Type entity.
	 */
	public Date getCreatedTimestamp() {
	    return createdTimestamp;
	}

	/**
	 * Sets the created timestamp of this Disease_Type entity.
	 * @param createdTimestamp the created timestamp to be set for this Disease_Type entity.
	 */
	public void setCreatedTimestamp(Date createdTimestamp) {
	    this.createdTimestamp = createdTimestamp;
	}

	/** 
	 * Returns the modified timestamp of this Disease_Type entity.
	 * @return the modified timestamp of this Disease_Type entity.
	 */
	public Date getModifiedTimestamp() {
	    return modifiedTimestamp;
	}

	/**
	 * Sets the modified timestamp of this Disease_Type entity.
	 * @param modifiedTimestamp the modified timestamp to be set for this Disease_Type entity.
	 */
	public void setModifiedTimestamp(Date modifiedTimestamp) {
	    this.modifiedTimestamp = modifiedTimestamp;
	}

	/**
	 * Returns the string representation of this Disease_Type entity.
	 * @return the string representation of this Disease_Type entity.
	 */
	@Override
	public String toString() {
	    return "Disease_Type [id=" + diseaseTypeId + ", type=" + type + ", medicine=" + medicine + ", createdBy=" + createdBy
	            + ", modifiedBy=" + modifiedBy + ", createdTimestamp=" + createdTimestamp + ", modifiedTimestamp=" + modifiedTimestamp + "]";
	}
}
