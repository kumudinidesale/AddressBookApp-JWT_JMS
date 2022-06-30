package com.example.addressbookapp1.service;

import com.example.addressbookapp1.dto.AddressBookDTO;
import com.example.addressbookapp1.model.AddressBook;

import java.util.List;


public interface IAddressBookService {

    //save data to repository
    AddressBook createAddressBookData(AddressBookDTO addressBookDTO);

    AddressBook getDataById(Integer id);



    //get All Data from token
    List<AddressBook> getAddressBookDataByToken(String token);


    //get records created for particular id by generating token for that id
    AddressBook getRecordByToken(String token);


    //update records by providing token generated for particular id
    AddressBook updateRecordByToken(String token, AddressBookDTO addressBookDTO);



    //deleted records by token
    AddressBook deleteRecordByToken(String token);

    AddressBook updateDataById(Integer id, AddressBookDTO employeeDTO);

    String deleteDataById(Integer id);

    List<AddressBook> getAddressBookData();

    List<AddressBook> sortCityAscOrder();

    //list of book in descending order
    List<AddressBook> sortCityDescOrder();

}

