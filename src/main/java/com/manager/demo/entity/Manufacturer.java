package com.manager.demo.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import org.hibernate.validator.constraints.Range;

/**
 * Represents a Manufacturer entity in the system.
 */
//@Entity
//@Table(name="Manufacturer")
//@Builder
//public class Manufacturer {
//    @Id
//    @GeneratedValue
//    int manufacturerId;
//    @NotBlank(message = "Manufacturer name is Mandatory")
//    @Size(min = 3, message = "Manufacturer name should have at least 3 characters")
//    @Size(max = 20, message = "Manufacturer name should not have more than 20 characters")
//    @Pattern(regexp = "^[^0-9]*$", message = "Manufacturer name only contain character")
//    String manufacturerName;
//    @NotBlank(message = "Contact is Mandatory")
//    @Size(min = 7, message = "Contact should have at least 3 characters")
//    @Size(max = 12, message = "Contact should not have more than 12 characters")
//    @Pattern(regexp = "^[0-9]+$", message = "Contact must contain only integer")
//    String contact;
//
//    @NotNull(message = "Medicine details is Mandatory")
//    @Size(min = 1, max = 12, message = "List must contain between 1 and 12 elements")
//    @OneToMany(targetEntity = Medicine.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "manu_fk", referencedColumnName = "manufacturerId")
//    List<Medicine> medicine;
//
//    /**
//     * Default constructor for the Manufacturer class.
//     */
//    Manufacturer(){}
//
//    /**
//     * Constructor for the Manufacturer class with parameters.
//     * @param manufacturerId the ID of the manufacturer
//     * @param manufacturerName the name of the manufacturer
//     * @param contact the contact information of the manufacturer
//     * @param medicine the list of medicines associated with the manufacturer
//     */
//    public Manufacturer(int manufacturerId, String manufacturerName, String contact, List<Medicine> medicine) {
//        super();
//        this.manufacturerId = manufacturerId;
//        this.manufacturerName = manufacturerName;
//        this.contact = contact;
//        this.medicine = medicine;
//    }
//
//    /**
//     * Returns the ID of the manufacturer.
//     * @return the ID of the manufacturer
//     */
//    public int getId() {
//        return manufacturerId;
//    }
//
//    /**
//     * Sets the ID of the manufacturer.
//     * @param manufacturerId the ID to be set for the manufacturer
//     */
//    public void setId(int manufacturerId) {
//        this.manufacturerId = manufacturerId;
//    }
//
//    /**
//     * Returns the name of the manufacturer.
//     * @return the name of the manufacturer
//     */
//    public String getManufacturerName() {
//        return manufacturerName;
//    }
//
//    /**
//     * Sets the name of the manufacturer.
//     * @param manufacturerName the name to be set for the manufacturer
//     */
//    public void setManufacturerName(String manufacturerName) {
//        this.manufacturerName = manufacturerName;
//    }
//
//    /**
//     * Returns the contact information of the manufacturer.
//     * @return the contact information of the manufacturer
//     */
//    public String getContact() {
//        return contact;
//    }
//
//    /**
//     * Sets the contact information of the manufacturer.
//     * @param contact the contact information to be set for the manufacturer
//     */
//    public void setContact(String contact) {
//        this.contact = contact;
//    }
//
//    /**
//     * Returns the list of medicines associated with the manufacturer.
//     * @return the list of medicines associated with the manufacturer
//     */
//    public List<Medicine> getMedicine() {
//        return medicine;
//    }
//
//    /**
//     * Sets the list of medicines associated with the manufacturer.
//     * @param medicine the list of medicines to be set for the manufacturer
//     */
//    public void setMedicine(List<Medicine> medicine) {
//        this.medicine = medicine;
//    }
//
//
//    /**
//     * Returns the string representation of this Manufacturer entity.
//     * @return the string representation of this Manufacturer entity.
//     */
    @Entity
  @Table(name="OnlyManufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue
    int Id;

    public Manufacturer(int i, String tesla, String number, List<Medicine> medicines) {
    }



    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    @Column
    String manufacturerName;
    @Column
    String medicineName;
    @Column
     Date delivaryDate;
    @Column
    int quantity;

    int totalBill;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public Manufacturer(int id, String manufacturerName, String medicineName, Date delivaryDate, int quantity) {
        Id = id;
        this.manufacturerName = manufacturerName;
        this.medicineName = medicineName;
        this.delivaryDate = delivaryDate;
        this.quantity = quantity;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Manufacturer() {
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "Id=" + Id +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", delivaryDate=" + delivaryDate +
                ", quantity=" + quantity +
                ", totalBill=" + totalBill +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDelivaryDate() {
        return delivaryDate;
    }

    public void setDelivaryDate(Date delivaryDate) {
        this.delivaryDate = delivaryDate;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

}
