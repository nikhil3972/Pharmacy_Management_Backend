package com.manager.demo.entity;//package com.manager.demo.entity;
//
//import java.sql.Date;
//import java.util.List;
//
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import junit.runner.Version;

//
///**
// * This class represents a Disease entity with its attributes and relationships to other entities.
// */
//@Entity
//@Table(name="Disease")
//@Builder
//public class Disease {
//
//	@Id
//	@GeneratedValue
//	int id;
//
//
//	@NotBlank(message = "Disease name is Mandatory")
//	@Size(min = 3, message = "Disease name should have at least 3 characters")
//	@Size(max = 20, message = "Disease name should not have more than 20 characters")
//	@Pattern(regexp = "^[^0-9]*$", message = "Disease name only contain character")
//	String diseaseName;
//
//	@NotBlank(message = "Disease information is Mandatory")
//	@Size(min = 3, message = "Disease information should have at least 3 characters")
//	String diseaseInfo;
//
//	@NotNull(message = "recMed is Mandatory")
//	@Size(min = 3, max = 12, message = "Must contain at least 3 characters")
////	@OneToMany(targetEntity = DiseaseType.class, cascade = CascadeType.ALL)
////	@JoinColumn(name = "disease_fk", referencedColumnName = "diseaseId")
//	String recMed;
//
//	/**
//	 * Default constructor for Disease.
//	 */
//	public Disease() {}
//
//	/**
//	 * Constructor for Disease with specified parameters.
//	 * @param id The ID of the disease.
//	 * @param diseaseName The name of the disease.
//	 * @param diseaseInfo The information about the disease.
//	 * @param recMed The list of recommended medicine associated with the disease.
//	 */
//
//	public Disease(int id, String diseaseName, String diseaseInfo, String recMed){
//		this.id = id;
//		this.diseaseName = diseaseName;
//		this.diseaseInfo = diseaseInfo;
//		this.recMed=recMed;
//	}
//
//	/**
//	 * Gets the id of the Disease.
//	 * @return int value of the id.
//	 */
//	public int getId() {
//		return id;
//	}
//
//	/**
//	 * Sets the id of the Disease.
//	 * @param id the int value of the id to be set.
//	 */
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	/**
//	 * Gets the name of the Disease.
//	 * @return String value of the name.
//	 */
//	public String getDiseaseName() {
//		return diseaseName;
//	}
//
//	/**
//	 * Sets the name of the Disease.
//	 * @param diseaseName the String value of the name to be set.
//	 */
//	public void setDiseaseName(String diseaseName) {
//		this.diseaseName = diseaseName;
//	}
//
//	/**
//	 * Gets the information about the Disease.
//	 * @return String value of the information.
//	 */
//	public String getDiseaseInfo() {
//		return diseaseInfo;
//	}
//
//	/**
//	 * Sets the information about the Disease.
//	 * @param diseaseInfo the String value of the information to be set.
//	 */
//	public void setDiseaseInfo(String diseaseInfo) {
//		this.diseaseInfo = diseaseInfo;
//	}
//
//	/**
//	 * Gets the list of Disease_Type associated with the Disease.
//	 * @return List of Disease_Type objects.
//	 */
//	public String getRecMed() {
//		return recMed;
//	}
//
//	/**
//	 * Sets the list of Disease_Type associated with the Disease.
//	 * @param recMed the recommended medicine to be set.
//	 */
//	public void setRecMed(String recMed) {
//		this.recMed = recMed;
//	}
//
//	/**
//	 * Returns a string representation of this Disease object.
//	 * @return a string representation of this Disease object
//	 */
//	@Override
//	public String toString() {
//		return "Disease [diseaseId=" + id + ", diseaseName=" + diseaseName + ", diseaseInfo=" + diseaseInfo + ", recMed=" + recMed
//				+ "]";
//	}
//}
//


@Entity
@Table(name="Disease")
public class Disease {
	@Id
	@GeneratedValue
	int id;

	@Column
	String diseaseName;
	@Column
	String diseaseInfo;
	@Column
	String recMed;

	public Disease() {
	}

	public Disease(int id, String diseaseName, String diseaseInfo, String recMed) {
		this.id = id;
		this.diseaseName = diseaseName;
		this.diseaseInfo = diseaseInfo;
		this.recMed = recMed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getDiseaseInfo() {
		return diseaseInfo;
	}

	public void setDiseaseInfo(String diseaseInfo) {
		this.diseaseInfo = diseaseInfo;
	}

	public String getRecMed() {
		return recMed;
	}

	public void setRecMed(String recMed) {
		this.recMed = recMed;
	}
}
