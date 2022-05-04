package com.example.addressbookapp1.controller;


import com.example.addressbookapp1.dto.AddressBookDTO;
import com.example.addressbookapp1.dto.ResponseDTO;
import com.example.addressbookapp1.model.exception.AddresssBookException;
import com.example.addressbookapp1.model.AddressBook;
import com.example.addressbookapp1.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/AddressBookApp")
@Slf4j
public class AddressBookController {
    @Autowired
    private IAddressBookService addressBookService;



    //Accepts the  data in JSON format and stores it in DB

    @PostMapping(path = "/create")
    public ResponseEntity<String> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        String newContact = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO respDTO = new ResponseDTO("New Contact Added in AddressBook ", newContact);
        return new ResponseEntity (respDTO, HttpStatus.CREATED);
    }


    //get all data by using token

    @GetMapping(value = "/retrieve/{token}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable String token)
    {
        List<AddressBook> listOfContacts = addressBookService.getAddressBookDataByToken(token);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:",listOfContacts);
        return new ResponseEntity(dto,HttpStatus.OK);
    }


    // get data for particular id

    @GetMapping("/get/{token}")
    public ResponseEntity<String> getRecordById(@PathVariable String token) throws AddresssBookException {
        AddressBook newAddressBook = addressBookService.getRecordByToken(token);
        ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully",newAddressBook);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

// update  record data by token


    @PutMapping("/update/{token}")
    public ResponseEntity<String> updateRecordById(@PathVariable String token,@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBook entity = addressBookService.updateRecordByToken(token,addressBookDTO);
        ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully",entity);
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }

    /// delete records from database using token



    @DeleteMapping("/delete/{token}")
    public ResponseEntity<String> deleteRecordById(@PathVariable String token){
        ResponseDTO dto = new ResponseDTO("Address Book Record deleted successfully",addressBookService.deleteRecordByToken(token));
        return new ResponseEntity(dto,HttpStatus.OK);
    }
}
