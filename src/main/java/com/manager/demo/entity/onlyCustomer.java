package com.manager.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="OnlyCustomer")
public class onlyCustomer {

    @Id
    @GeneratedValue
    int Id;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
   String contactNo;
    @Column
    String medicineName;
    @Column
   int price;


    onlyCustomer(){}

    public onlyCustomer(int customerId, String firstName, String lastName, String contact, String medicineName,int price) {
        super();
        this.Id = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contact;
        this.medicineName = medicineName;
        this.price=price;

    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getContact() {
        return contactNo;
    }
    public void setContact(String contact) {
        this.contactNo = contact;
    }
    public void setMedicineName(String name){
        this.medicineName=name; }
    public String getMedicineName(){
        return this.medicineName;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    @Override
    public String toString() {
        return "Customer [id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
                + ", medicine=" + medicineName + ", price" + price + "]";
    }
}
