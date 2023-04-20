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

/**
 * Represents a Manufacturer entity in the system.
 */
@Entity
@Table(name="Manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue
    int id;
    String name;
    String contact;

    @OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "manu_fk", referencedColumnName = "id")
    List<Medicine> medicine;

    String created_by;
    String modified_by;
    Date created_ts;
    Date modified_ts;

    /**
     * Default constructor for the Manufacturer class.
     */
    Manufacturer(){}

    /**
     * Constructor for the Manufacturer class with parameters.
     * @param id the ID of the manufacturer
     * @param name the name of the manufacturer
     * @param contact the contact information of the manufacturer
     * @param medicine the list of medicines associated with the manufacturer
     * @param created_by the username of the user who created the manufacturer entity
     * @param modified_by the username of the user who last modified the manufacturer entity
     * @param created_ts the timestamp when the manufacturer entity was created
     * @param modified_ts the timestamp when the manufacturer entity was last modified
     */
    public Manufacturer(int id, String name, String contact, List<Medicine> medicine, String created_by, String modified_by, Date created_ts, Date modified_ts) {
        super();
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.medicine = medicine;
        this.created_by = created_by;
        this.modified_by = modified_by;
        this.created_ts = created_ts;
        this.modified_ts = modified_ts;
    }

    /**
     * Returns the ID of the manufacturer.
     * @return the ID of the manufacturer
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the manufacturer.
     * @param id the ID to be set for the manufacturer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the manufacturer.
     * @return the name of the manufacturer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the manufacturer.
     * @param name the name to be set for the manufacturer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the contact information of the manufacturer.
     * @return the contact information of the manufacturer
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the contact information of the manufacturer.
     * @param contact the contact information to be set for the manufacturer
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Returns the list of medicines associated with the manufacturer.
     * @return the list of medicines associated with the manufacturer
     */
    public List<Medicine> getMedicine() {
        return medicine;
    }

    /**
     * Sets the list of medicines associated with the manufacturer.
     * @param medicine the list of medicines to be set for the manufacturer
     */
    public void setMedicine(List<Medicine> medicine) {
        this.medicine = medicine;
    }

    /**
     * Returns the username of the user who created the manufacturer entity.
     * @return the username of the user who created the manufacturer entity
     */
    public String getCreated_by() {
        return created_by;
    }

    /** 
     * Sets the creator of this Manufacturer entity.
     * @param created_by the creator to be set for this Manufacturer entity.
     */
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    /** 
     * Returns the modifier of this Manufacturer entity.
     * @return the modifier of this Manufacturer entity.
     */
    public String getModified_by() {
        return modified_by;
    }

    /**
     * Sets the modifier of this Manufacturer entity.
     * @param modified_by the modifier to be set for this Manufacturer entity.
     */
    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    /**
     * Returns the created timestamp of this Manufacturer entity.
     * @return the created timestamp of this Manufacturer entity.
     */
    public Date getCreated_ts() {
        return created_ts;
    }

    /**
     * Sets the created timestamp of this Manufacturer entity.
     * @param created_ts the created timestamp to be set for this Manufacturer entity.
     */
    public void setCreated_ts(Date created_ts) {
        this.created_ts = created_ts;
    }

    /**
     * Returns the modified timestamp of this Manufacturer entity.
     * @return the modified timestamp of this Manufacturer entity.
     */
    public Date getModified_ts() {
        return modified_ts;
    }

    /**
     * Sets the modified timestamp of this Manufacturer entity.
     * @param modified_ts the modified timestamp to be set for this Manufacturer entity.
     */
    public void setModified_ts(Date modified_ts) {
        this.modified_ts = modified_ts;
    }

    /**
     * Returns the string representation of this Manufacturer entity.
     * @return the string representation of this Manufacturer entity.
     */
    @Override
    public String toString() {
        return "Manufacturer [id=" + id + ", name=" + name + ", contact=" + contact + ", medicine=" + medicine
                + ", created_by=" + created_by + ", modified_by=" + modified_by + ", created_ts=" + created_ts
                + ", modified_ts=" + modified_ts + "]";
    }
}
