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

	/**
	 * Default constructor for DiseaseType.
	 */
	public DiseaseType() {}

	/**
	 * Constructor for DiseaseType with specified parameters.
	 * @param diseaseTypeId The ID of the disease type.
	 * @param type The type of the disease.
	 * @param medicine The list of medicines associated with the disease type.
	 */
	public DiseaseType(int diseaseTypeId, String type, List<Medicine> medicine){
		super();
		this.diseaseTypeId = diseaseTypeId;
		this.type = type;
		this.medicine = medicine;
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
	 * Returns the string representation of this Disease_Type entity.
	 * @return the string representation of this Disease_Type entity.
	 */
	@Override
	public String toString() {
	    return "Disease_Type [id=" + diseaseTypeId + ", type=" + type + ", medicine=" + medicine + "]";
	}
}
