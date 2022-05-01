package com.example.addressbookapp1.service;

import com.example.addressbookapp1.dto.AddressBookDTO;
import com.example.addressbookapp1.model.AddressBook;

import java.util.List;


public interface IAddressBookService {

    //save data to repository
    String createAddressBookData(AddressBookDTO addressBookDTO);

    //get All Data from token
    List<AddressBook> getAddressBookDataByToken(String token);


    //get records created for particular id by generating token for that id
    AddressBook getRecordByToken(String token);


    //update records by providing token generated for particular id
    AddressBook updateRecordByToken(String token, AddressBookDTO addressBookDTO);



    //deleted records by token
    AddressBook deleteRecordByToken(String token);
}

