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
    private int id;

    private String fullName;



    private String address;
    private String phoneNumber;
    private String city;
    private String state;
    private int zip;


    public AddressBook() {

    }
// Created constructor for post address method

    public AddressBook(AddressBookDTO addressBookDTO) {
        super();
        this.fullName = addressBookDTO.getFullName();

        this.address = addressBookDTO.getAddress();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
    }

    //Created constructor for update by id method
    public void updateAddressBook( AddressBookDTO addressBookDTO) {

        this.fullName = addressBookDTO.getFullName();

        this.address = addressBookDTO.getAddress();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
    }
}
