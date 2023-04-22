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
import org.hibernate.validator.constraints.Range;

/**
 * Represents a Manufacturer entity in the system.
 */
@Entity
@Table(name="Manufacturer")
@Builder
public class Manufacturer {
    @Id
    @GeneratedValue
    int manufacturerId;
    @NotBlank(message = "Manufacturer name is Mandatory")
    @Size(min = 3, message = "Manufacturer name should have at least 3 characters")
    @Size(max = 20, message = "Manufacturer name should not have more than 20 characters")
    @Pattern(regexp = "^[^0-9]*$", message = "Manufacturer name only contain character")
    String manufacturerName;
    @NotBlank(message = "Contact is Mandatory")
    @Range(min = 7, max = 12, message = "Contact size is must between range of 7 & 12")
    @Pattern(regexp = "^[0-9]+$", message = "Contact must contain only integer")
    String contact;

    @NotNull(message = "Medicine details is Mandatory")
    @Size(min = 1, max = 12, message = "List must contain between 1 and 12 elements")
    @OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "manu_fk", referencedColumnName = "manufacturerId")
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
     * Default constructor for the Manufacturer class.
     */
    Manufacturer(){}

    /**
     * Constructor for the Manufacturer class with parameters.
     * @param manufacturerId the ID of the manufacturer
     * @param manufacturerName the name of the manufacturer
     * @param contact the contact information of the manufacturer
     * @param medicine the list of medicines associated with the manufacturer
     * @param createdBy the username of the user who created the manufacturer entity
     * @param modifiedBy the username of the user who last modified the manufacturer entity
     * @param createdTimestamp the timestamp when the manufacturer entity was created
     * @param modifiedTimestamp the timestamp when the manufacturer entity was last modified
     */
    public Manufacturer(int manufacturerId, String manufacturerName, String contact, List<Medicine> medicine, String createdBy, String modifiedBy, Date createdTimestamp, Date modifiedTimestamp) {
        super();
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
        this.contact = contact;
        this.medicine = medicine;
        this.createdBy = Manufacturer.this.createdBy;
        this.modifiedBy = Manufacturer.this.modifiedBy;
        this.createdTimestamp = createdTimestamp;
        this.modifiedTimestamp = modifiedTimestamp;
    }

    /**
     * Returns the ID of the manufacturer.
     * @return the ID of the manufacturer
     */
    public int getId() {
        return manufacturerId;
    }

    /**
     * Sets the ID of the manufacturer.
     * @param manufacturerId the ID to be set for the manufacturer
     */
    public void setId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    /**
     * Returns the name of the manufacturer.
     * @return the name of the manufacturer
     */
    public String getName() {
        return manufacturerName;
    }

    /**
     * Sets the name of the manufacturer.
     * @param manufacturerName the name to be set for the manufacturer
     */
    public void setName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
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
    public String getCreatedBy() {
        return createdBy;
    }

    /** 
     * Sets the creator of this Manufacturer entity.
     * @param createdBy the creator to be set for this Manufacturer entity.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = Manufacturer.this.createdBy;
    }

    /** 
     * Returns the modifier of this Manufacturer entity.
     * @return the modifier of this Manufacturer entity.
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Sets the modifier of this Manufacturer entity.
     * @param modifiedBy the modifier to be set for this Manufacturer entity.
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = Manufacturer.this.modifiedBy;
    }

    /**
     * Returns the created timestamp of this Manufacturer entity.
     * @return the created timestamp of this Manufacturer entity.
     */
    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     * Sets the created timestamp of this Manufacturer entity.
     * @param createdTimestamp the created timestamp to be set for this Manufacturer entity.
     */
    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     * Returns the modified timestamp of this Manufacturer entity.
     * @return the modified timestamp of this Manufacturer entity.
     */
    public Date getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    /**
     * Sets the modified timestamp of this Manufacturer entity.
     * @param modifiedTimestamp the modified timestamp to be set for this Manufacturer entity.
     */
    public void setModifiedTimestamp(Date modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }

    /**
     * Returns the string representation of this Manufacturer entity.
     * @return the string representation of this Manufacturer entity.
     */
    @Override
    public String toString() {
        return "Manufacturer [manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName + ", contact=" + contact + ", medicine=" + medicine
                + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdTimestamp=" + createdTimestamp
                + ", modifiedTimestamp=" + modifiedTimestamp + "]";
    }
}
