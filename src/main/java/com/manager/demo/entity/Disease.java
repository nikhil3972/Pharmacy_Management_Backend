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
 * This class represents a Disease entity with its attributes and relationships to other entities.
 */
@Entity
@Table(name="Disease")
@Builder
public class Disease {
	
	@Id
	@GeneratedValue
	int diseaseId;

<<<<<<< HEAD

=======
	@NotBlank(message = "Disease name is Mandatory")
	@Size(min = 3, message = "Disease name should have at least 3 characters")
	@Size(max = 20, message = "Disease name should not have more than 20 characters")
	@Pattern(regexp = "^[^0-9]*$", message = "Disease name only contain character")
	String diseaseName;

	@NotBlank(message = "Disease information is Mandatory")
	@Size(min = 3, message = "Disease information should have at least 3 characters")
	String diseaseInfo;

	@NotNull(message = "Disease Type details is Mandatory")
	@Size(min = 1, max = 12, message = "List must contain between 1 and 12 elements")
	@OneToMany(targetEntity = DiseaseType.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "disease_fk", referencedColumnName = "diseaseId")
	List<DiseaseType> diseaseType;

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
>>>>>>> 80f10e8b414bcecae0b8ca66c2ee9734a9aef266

	/**
	 * Default constructor for Disease.
	 */
	public Disease() {}

	/**
	 * Constructor for Disease with specified parameters.
	 * @param diseaseId The ID of the disease.
	 * @param diseaseName The name of the disease.
	 * @param diseaseInfo The information about the disease.
	 * @param diseaseType The list of disease types associated with the disease.
	 * @param createdBy The user who created the disease.
	 * @param modifiedBy The user who last modified the disease.
	 * @param createdTimestamp The timestamp when the disease was created.
	 * @param modifiedTimestamp The timestamp when the disease was last modified.
	 */
<<<<<<< HEAD
	

	

	public Disease(int id, String name, String info, List<DiseaseType> disease_type, String created_by, String modified_by, Date created_ts, Date modified_ts){

		this.id = id;
		this.name = name;
		this.info = info;
		this.disease_type = disease_type;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_ts = created_ts;
		this.modified_ts = modified_ts;
=======

	public Disease(int diseaseId, String diseaseName, String diseaseInfo, List<DiseaseType> diseaseType, String createdBy, String modifiedBy, Date createdTimestamp, Date modifiedTimestamp){
		this.diseaseId = diseaseId;
		this.diseaseName = diseaseName;
		this.diseaseInfo = diseaseInfo;
		this.diseaseType = diseaseType;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdTimestamp = createdTimestamp;
		this.modifiedTimestamp = modifiedTimestamp;
>>>>>>> 80f10e8b414bcecae0b8ca66c2ee9734a9aef266
	}

	/**
	 * Gets the id of the Disease.
	 * @return int value of the id.
	 */
	public int getId() {
		return diseaseId;
	}
	
	/**
	 * Sets the id of the Disease.
	 * @param diseaseId the int value of the id to be set.
	 */
	public void setId(int diseaseId) {
		this.diseaseId = diseaseId;
	}
	
	/**
	 * Gets the name of the Disease.
	 * @return String value of the name.
	 */
	public String getName() {
		return diseaseName;
	}
	
	/**
	 * Sets the name of the Disease.
	 * @param diseaseName the String value of the name to be set.
	 */
	public void setName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	
	/**
	 * Gets the information about the Disease.
	 * @return String value of the information.
	 */
	public String getInfo() {
		return diseaseInfo;
	}
	
	/**
	 * Sets the information about the Disease.
	 * @param diseaseInfo the String value of the information to be set.
	 */
	public void setInfo(String diseaseInfo) {
		this.diseaseInfo = diseaseInfo;
	}
	
	/**
	 * Gets the list of Disease_Type associated with the Disease.
	 * @return List of Disease_Type objects.
	 */
	public List<DiseaseType> getDiseaseType() {
		return diseaseType;
	}
	
	/**
	 * Sets the list of Disease_Type associated with the Disease.
	 * @param diseaseType the List of Disease_Type objects to be set.
	 */
	public void setDiseaseType(List<DiseaseType> diseaseType) {
		this.diseaseType = diseaseType;
	}
	
	/**
	 * Gets the name of the user who created the Disease.
	 * @return String value of the user name.
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * Sets the name of the user who created the Disease.
	 * @param createdBy the String value of the user name to be set.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * Gets the name of the user who last modified the Disease.
	 * @return String value of the user name.
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}
	
	/**
	 * Sets the name of the user who last modified the Disease.
	 * @param modifiedBy the String value of the user name to be set.
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	/**
	 * Gets the timestamp of when the Disease was created.
	 * @return Date object representing the timestamp.
	 */
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	
	/**
	 * Sets the timestamp of when the Disease was created.
	 * @param createdTimestamp the Date object representing the timestamp to be set.
	 */
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
	/**
	 * Gets the timestamp of when the Disease was last modified.
	 * @return Date object representing the timestamp.
	 */
	public Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}
	/**
	 * Sets the modified timestamp of this Disease object.
	 * @param modifiedTimestamp the modified timestamp to be set
	 */
	public void setModifiedTimestamp(Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}

	/**
	 * Returns a string representation of this Disease object.
	 * @return a string representation of this Disease object
	 */
	@Override
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + ", diseaseInfo=" + diseaseInfo + ", diseaseType=" + diseaseType
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdTimestamp=" + createdTimestamp
				+ ", modifiedTimestamp=" + modifiedTimestamp + "]";
	}
}

