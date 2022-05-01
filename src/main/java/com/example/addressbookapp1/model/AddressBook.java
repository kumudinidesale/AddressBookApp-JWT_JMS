package com.example.addressbookapp1.model;

import com.example.addressbookapp1.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AddressBook_table")
@Data
public class AddressBook {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;

    private String email;

    private String address;
    private String phoneNumber;
    private String city;
    private String state;
    private int zip;


    public AddressBook() {
        super();
    }
// Created constructor for post address method

    public AddressBook(AddressBookDTO addressBookDTO) {
        super();
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.email= addressBookDTO.getEmail();
        this.address = addressBookDTO.getAddress();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
    }

    //Created constructor for update by id method
    public AddressBook(Integer id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.email = addressBookDTO.getEmail();
        this.address = addressBookDTO.getAddress();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();


    }



//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String email) {
//        this.address = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public Integer getZip() {
//        return zip;
//    }
//
//    public void setZip(Integer zip) {
//        this.zip = zip;
//    }
}
