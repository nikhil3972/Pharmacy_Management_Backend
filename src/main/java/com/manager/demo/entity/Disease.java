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
	int id;
	String name;
	String info;
	
	@OneToMany(targetEntity = DiseaseType.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "disease_fk", referencedColumnName = "id")
	List<DiseaseType> disease_type;
	
	String created_by;
	String modified_by;
	Date created_ts;
	Date modified_ts;



	/**
	 * Default constructor for Disease.
	 */
	public Disease() {}

	/**
	 * Constructor for Disease with specified parameters.
	 * @param id The ID of the disease.
	 * @param name The name of the disease.
	 * @param info The information about the disease.
	 * @param disease_type The list of disease types associated with the disease.
	 * @param created_by The user who created the disease.
	 * @param modified_by The user who last modified the disease.
	 * @param created_ts The timestamp when the disease was created.
	 * @param modified_ts The timestamp when the disease was last modified.
	 */
	

	

	public Disease(int id, String name, String info, List<DiseaseType> disease_type, String created_by, String modified_by, Date created_ts, Date modified_ts){

		this.id = id;
		this.name = name;
		this.info = info;
		this.disease_type = disease_type;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_ts = created_ts;
		this.modified_ts = modified_ts;
	}

	/**
	 * Gets the id of the Disease.
	 * @return int value of the id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id of the Disease.
	 * @param id the int value of the id to be set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the name of the Disease.
	 * @return String value of the name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the Disease.
	 * @param name the String value of the name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the information about the Disease.
	 * @return String value of the information.
	 */
	public String getInfo() {
		return info;
	}
	
	/**
	 * Sets the information about the Disease.
	 * @param info the String value of the information to be set.
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	
	/**
	 * Gets the list of Disease_Type associated with the Disease.
	 * @return List of Disease_Type objects.
	 */
	public List<DiseaseType> getDisease_type() {
		return disease_type;
	}
	
	/**
	 * Sets the list of Disease_Type associated with the Disease.
	 * @param disease_type the List of Disease_Type objects to be set.
	 */
	public void setDisease_type(List<DiseaseType> disease_type) {
		this.disease_type = disease_type;
	}
	
	/**
	 * Gets the name of the user who created the Disease.
	 * @return String value of the user name.
	 */
	public String getCreated_by() {
		return created_by;
	}
	
	/**
	 * Sets the name of the user who created the Disease.
	 * @param created_by the String value of the user name to be set.
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	/**
	 * Gets the name of the user who last modified the Disease.
	 * @return String value of the user name.
	 */
	public String getModified_by() {
		return modified_by;
	}
	
	/**
	 * Sets the name of the user who last modified the Disease.
	 * @param modified_by the String value of the user name to be set.
	 */
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	
	/**
	 * Gets the timestamp of when the Disease was created.
	 * @return Date object representing the timestamp.
	 */
	public Date getCreated_ts() {
		return created_ts;
	}
	
	/**
	 * Sets the timestamp of when the Disease was created.
	 * @param created_ts the Date object representing the timestamp to be set.
	 */
	public void setCreated_ts(Date created_ts) {
		this.created_ts = created_ts;
	}
	
	/**
	 * Gets the timestamp of when the Disease was last modified.
	 * @return Date object representing the timestamp.
	 */
	public Date getModified_ts() {
		return modified_ts;
	}
	/**
	 * Sets the modified timestamp of this Disease object.
	 * @param modified_ts the modified timestamp to be set
	 */
	public void setModified_ts(Date modified_ts) {
		this.modified_ts = modified_ts;
	}

	/**
	 * Returns a string representation of this Disease object.
	 * @return a string representation of this Disease object
	 */
	@Override
	public String toString() {
		return "Disease [id=" + id + ", name=" + name + ", info=" + info + ", disease_type=" + disease_type
				+ ", created_by=" + created_by + ", modified_by=" + modified_by + ", created_ts=" + created_ts
				+ ", modified_ts=" + modified_ts + "]";
	}
}
