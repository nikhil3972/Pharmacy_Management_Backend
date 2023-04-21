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
	int id;
	
	/**
	 * The type of the disease.
	 */
	String type;
	
	/**
	 * The list of medicines associated with the disease type.
	 */
	@OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "disease_type_fk", referencedColumnName = "id")
	List<Medicine> medicine;
	
	/**
	 * The name of the user who created the disease type record.
	 */
	String created_by;
	
	/**
	 * The name of the user who last modified the disease type record.
	 */
	String modified_by;
	
	/**
	 * The timestamp when the disease type record was created.
	 */
	Date created_ts;
	
	/**
	 * The timestamp when the disease type record was last modified.
	 */
	Date modified_ts;

	/**
	 * Default constructor for DiseaseType.
	 */
	public DiseaseType() {}

	/**
	 * Constructor for DiseaseType with specified parameters.
	 * @param id The ID of the disease type.
	 * @param type The type of the disease.
	 * @param medicine The list of medicines associated with the disease type.
	 * @param created_by The user who created the disease type.
	 * @param modified_by The user who last modified the disease type.
	 * @param created_ts The timestamp when the disease type was created.
	 * @param modified_ts The timestamp when the disease type was last modified.
	 */
	public DiseaseType(int id, String type, List<Medicine> medicine, String created_by, String modified_by, Date created_ts, Date modified_ts){
		super();
		this.id = id;
		this.type = type;
		this.medicine = medicine;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_ts = created_ts;
		this.modified_ts = modified_ts;
	}

	/**
	 * Gets the ID of the disease type.
	 * @return The ID of the disease type.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the ID of the disease type.
	 * @param id The ID of the disease type.
	 */
	public void setId(int id) {
		this.id = id;
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
	public String getCreated_by() {
		return created_by;
	}
	
	/**
	 * Sets the name of the user who created the disease type record.
	 * @param created_by The name of the user who created the disease type record.
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	/**
	 * Gets the name of the user who last modified the disease type record.
	 * @return The name of the user who last modified the disease type record.
	 */
	public String getModified_by() {
		return modified_by;
	}
	
	/**
	 * Sets the name of the user who last modified the disease type record.
	 * @param modified_by The name of the user who last modified the disease type record.
	 */
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	
	/**
	 * Gets the timestamp when the disease type record was created.
	 * @return The timestamp when the disease type record was created.
	 */
	/** 
	 * Returns the created timestamp of this Disease_Type entity.
	 * @return the created timestamp of this Disease_Type entity.
	 */
	public Date getCreated_ts() {
	    return created_ts;
	}

	/**
	 * Sets the created timestamp of this Disease_Type entity.
	 * @param created_ts the created timestamp to be set for this Disease_Type entity.
	 */
	public void setCreated_ts(Date created_ts) {
	    this.created_ts = created_ts;
	}

	/** 
	 * Returns the modified timestamp of this Disease_Type entity.
	 * @return the modified timestamp of this Disease_Type entity.
	 */
	public Date getModified_ts() {
	    return modified_ts;
	}

	/**
	 * Sets the modified timestamp of this Disease_Type entity.
	 * @param modified_ts the modified timestamp to be set for this Disease_Type entity.
	 */
	public void setModified_ts(Date modified_ts) {
	    this.modified_ts = modified_ts;
	}

	/**
	 * Returns the string representation of this Disease_Type entity.
	 * @return the string representation of this Disease_Type entity.
	 */
	@Override
	public String toString() {
	    return "Disease_Type [id=" + id + ", type=" + type + ", medicine=" + medicine + ", created_by=" + created_by
	            + ", modified_by=" + modified_by + ", created_ts=" + created_ts + ", modified_ts=" + modified_ts + "]";
	}
}
