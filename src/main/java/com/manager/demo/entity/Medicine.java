package com.manager.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

/**
 * Entity class representing a Medicine.
 */
@Entity
@Table(name="Medicine")
@Builder
public class Medicine {
    @Id
    @GeneratedValue
    int id;
    String name;
    String description;
    String dosage;
    BigDecimal price;
    Date manufacture_date;
    Date expiry_date;
    int current_stock;
    String created_by;
    String modified_by;
    Date created_ts;
    Date modified_ts;

    /**
     * Default constructor for Medicine.
     */
    Medicine(){}

    /**
     * Constructor for Medicine with all parameters.
     * @param id the ID of the Medicine.
     * @param name the name of the Medicine.
     * @param description the description of the Medicine.
     * @param dosage the dosage of the Medicine.
     * @param price the price of the Medicine.
     * @param manufacture_date the manufacture date of the Medicine.
     * @param expiry_date the expiry date of the Medicine.
     * @param current_stock the current stock of the Medicine.
     * @param created_by the created by information of the Medicine.
     * @param modified_by the modified by information of the Medicine.
     * @param created_ts the created timestamp of the Medicine.
     * @param modified_ts the modified timestamp of the Medicine.
     */
    public Medicine(int id, String name, String description, String dosage, BigDecimal price, Date manufacture_date,
            Date expiry_date, int current_stock, String created_by, String modified_by, Date created_ts,
            Date modified_ts) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.dosage = dosage;
        this.price = price;
        this.manufacture_date = manufacture_date;
        this.expiry_date = expiry_date;
        this.current_stock = current_stock;
        this.created_by = created_by;
        this.modified_by = modified_by;
        this.created_ts = created_ts;
        this.modified_ts = modified_ts;
    }


    /** 
     * Returns the ID of this medicine entity.
     * @return the ID of this medicine entity.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of this medicine entity.
     * @param id the ID to be set for this medicine entity.
     */
    public void setId(int id) {
        this.id = id;
    }

    /** 
     * Returns the name of this medicine entity.
     * @return the name of this medicine entity.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this medicine entity.
     * @param name the name to be set for this medicine entity.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Returns the description of this medicine entity.
     * @return the description of this medicine entity.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this medicine entity.
     * @param description the description to be set for this medicine entity.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 
     * Returns the dosage of this medicine entity.
     * @return the dosage of this medicine entity.
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * Sets the dosage of this medicine entity.
     * @param dosage the dosage to be set for this medicine entity.
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    /** 
     * Returns the price of this medicine entity.
     * @return the price of this medicine entity.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of this medicine entity.
     * @param price the price to be set for this medicine entity.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /** 
     * Returns the manufacture date of this medicine entity.
     * @return the manufacture date of this medicine entity.
     */
    public Date getManufacture_date() {
        return manufacture_date;
    }

    /**
     * Sets the manufacture date of this medicine entity.
     * @param manufacture_date the manufacture date to be set for this medicine entity.
     */
    public void setManufacture_date(Date manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    /** 
     * Returns the expiry date of this medicine entity.
     * @return the expiry date of this medicine entity.
     */
    public Date getExpiry_date() {
        return expiry_date;
    }

    /**
     * Sets the expiry date of this medicine entity.
     * @param expiry_date the expiry date to be set for this medicine entity.
     */
    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    /** 
     * Returns the current stock of this medicine entity.
     * @return the current stock of this medicine entity.
     */
    public int getCurrent_stock() {
        return current_stock;
    }

    /**
     * Sets the current stock of this medicine entity.
     * @param current_stock the current stock to be set for this medicine entity.
     */
    public void setCurrent_stock(int current_stock) {
        this.current_stock = current_stock;
    }

    /** 
     * Returns the created by user of this medicine entity.
     * @return the created by user of this medicine entity.
     */
    public String getCreated_by() {
        return created_by;
    }

    /**
     * Sets the created by user of this medicine entity.
     * @param created_by the created by user to be set for this medicine entity.
     */
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    /** 
     * Returns the modified by user of this medicine entity.
     * @return the modified by user of this medicine entity.
     */
    public String getModified_by() {
        return modified_by;
    }

    /**
     * Sets the modified by user of this medicine entity.
     * @param modified_by the modified by user
     */
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	/**
	 * Returns the created timestamp of the Disease_Type object.
	 * @return The created timestamp of the Disease_Type object.
	 */
	public Date getCreated_ts() {
		return created_ts;}

	/**
	 * Sets the created timestamp of the Disease_Type object.
	 * @param created_ts The created timestamp of the Disease_Type object.
	 */
	public void setCreated_ts(Date created_ts) {}

	/**
	 * Returns the modified timestamp of the Disease_Type object.
	 * @return The modified timestamp of the Disease_Type object.
	 */
	public Date getModified_ts() {
		return modified_ts;}

	/**
	 * Sets the modified timestamp of the Disease_Type object.
	 * @param modified_ts The modified timestamp of the Disease_Type object.
	 */
	public void setModified_ts(Date modified_ts) {}
	
	/**
     * Returns the string representation of this Medicine entity.
     * @return the string representation of this Medicine entity.
     */
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", description=" + description + ", dosage=" + dosage
				+ ", price=" + price + ", manufacture_date=" + manufacture_date + ", expiry_date=" + expiry_date
				+ ", current_stock=" + current_stock + ", created_by=" + created_by + ", modified_by=" + modified_by
				+ ", created_ts=" + created_ts + ", modified_ts=" + modified_ts + "]";
	}	
}
