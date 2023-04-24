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
	 */

	



	public Disease(int diseaseId, String diseaseName, String diseaseInfo, List<DiseaseType> diseaseType){
		this.diseaseId = diseaseId;
		this.diseaseName = diseaseName;
		this.diseaseInfo = diseaseInfo;
		this.diseaseType = diseaseType;
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
	 * Returns a string representation of this Disease object.
	 * @return a string representation of this Disease object
	 */
	@Override
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + ", diseaseInfo=" + diseaseInfo + ", diseaseType=" + diseaseType
				+ "]";
	}
}

