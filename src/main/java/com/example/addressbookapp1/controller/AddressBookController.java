package com.example.addressbookapp1.controller;


import com.example.addressbookapp1.dto.AddressBookDTO;
import com.example.addressbookapp1.dto.ResponseDTO;
import com.example.addressbookapp1.exception.AddresssBookException;
import com.example.addressbookapp1.model.AddressBook;
import com.example.addressbookapp1.service.AddressBookService;
import com.example.addressbookapp1.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(allowedHeaders="*",origins="*")
@RestController
@RequestMapping("/AddressBookApp")
@Slf4j
public class AddressBookController {
    @Autowired
    private IAddressBookService addressBookService;


    //Accepts the  data in JSON format and stores it in DB

    @PostMapping(path = "/create")
    public ResponseEntity<String> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook newContact = addressBookService.createAddressBookData(addressBookDTO);

        ResponseDTO respDTO = new ResponseDTO("New Contact Added in AddressBook ", newContact);
        return new ResponseEntity(respDTO, HttpStatus.CREATED);
    }


    //get all data by using token

    @GetMapping(value = "/retrieve/{token}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable String token) {
        List<AddressBook> listOfContacts = addressBookService.getAddressBookDataByToken(token);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:", listOfContacts);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBook> listOfContacts = addressBookService.getAddressBookData();
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:", listOfContacts);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/getcount")
    public ResponseEntity<ResponseDTO> getAddressBookDataCount() {
        List<AddressBook> listOfContacts = addressBookService.getAddressBookData();
        Integer count = listOfContacts.size();
        ResponseDTO dto = new ResponseDTO("Data count successfully (:", count);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    // get data for particular id
    @GetMapping("/getrecord/{id}")
    public ResponseEntity<ResponseDTO> getDataById(@PathVariable int id) throws AddresssBookException {
        AddressBook existingEmployee = addressBookService.getDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Record for given ID Retrieved Successfully", existingEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }


    // get data for particular id

    @GetMapping("/get/{token}")
    public ResponseEntity<String> getRecordByToken(@PathVariable String token) throws AddresssBookException {
        AddressBook newAddressBook = addressBookService.getRecordByToken(token);
        ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully", newAddressBook);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    // update  record data by id
    @PutMapping("/Updaterecord/{id}")
    public ResponseEntity<ResponseDTO> updateDataById(@PathVariable int id,
                                                      @Valid @RequestBody AddressBookDTO employeeDTO)
            throws AddresssBookException {
        AddressBook updatedEmployee = addressBookService.updateDataById(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Record for particular ID Updated Successfully", updatedEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

// update  record data by token


    @PutMapping("/update/{token}")
    public ResponseEntity<String> updateRecordByToken(@PathVariable String token, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook entity = addressBookService.updateRecordByToken(token, addressBookDTO);
        ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully", entity);
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    // delete records from database using id
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteDataById(@PathVariable int id) throws AddresssBookException {
        ResponseDTO responseDTO = new ResponseDTO
                ("Record for particular ID Deleted Successfully", addressBookService.deleteDataById(id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /// delete records from database using token


    @DeleteMapping("/delete/{token}")
    public ResponseEntity<String> deleteRecordByToken(@PathVariable String token) {
        ResponseDTO dto = new ResponseDTO("Address Book Record deleted successfully", addressBookService.deleteRecordByToken(token));
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @GetMapping("/sortCity-ascending")
    public ResponseEntity<ResponseDTO> sortCityAscOrder() {
        List<AddressBook> book = addressBookService.sortCityAscOrder();
        ResponseDTO dto = new ResponseDTO("Address in ascending order :", book);
        return new ResponseEntity(dto, HttpStatus.OK);
    }


    @GetMapping("/sortCity-descending")
    public ResponseEntity<ResponseDTO> sortCityDescOrder() {
        List<AddressBook> book = addressBookService.sortCityDescOrder();
        ResponseDTO dto = new ResponseDTO("Address in  descending order :", book);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}