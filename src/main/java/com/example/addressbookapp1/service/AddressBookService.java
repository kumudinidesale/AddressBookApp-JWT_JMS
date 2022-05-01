package com.example.addressbookapp1.service;

import com.example.addressbookapp1.dto.AddressBookDTO;

import com.example.addressbookapp1.exception.AddresssBookException;
import com.example.addressbookapp1.model.AddressBook;
import com.example.addressbookapp1.repository.AddressBookRepository;
import com.example.addressbookapp1.util.EmailSenderService;
import com.example.addressbookapp1.util.TokenUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    TokenUtility tokenUtility;

    @Autowired
    EmailSenderService sender;


    // accepts the contact data in the form of AddressBookDTO and stores it in DB

    public String createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBook newAddress = new AddressBook(addressBookDTO);
        addressBookRepository.save(newAddress);
        String token = tokenUtility.createToken(newAddress.getId());
        sender.sendEmail(newAddress.getEmail(), "Test Email", "Registered SuccessFully, Kumud Hello: "
                +newAddress.getFirstName()+"Please Click here to get data-> "
                +"http://localhost:8080/AddressBookApp/get/"+token);
        return token;
    }



    // accepts the contact data in the form of AddressBookDTO and
     // updates the contact details having same Id from database

    public AddressBook updateRecordByToken(String token, AddressBookDTO addressBookDTO) {
        Integer id= tokenUtility.decodeToken(token);
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        if(addressBook.isEmpty()) {
            throw new AddresssBookException("Address Book Details for id not found");
        }
        AddressBook newBook = new AddressBook(id,addressBookDTO);
        addressBookRepository.save(newBook);
        sender.sendEmail(newBook.getEmail(), "Test Email", "Updated SuccessFully, hii: "
                +newBook.getFirstName()+"Please Click here to get data of updated id-> "
                +"http://localhost:8080/AddressBookApp/get/"+token);
        return newBook;
    }


   //accepts the contact Id and deletes the data of that contact from DB


    public AddressBook deleteRecordByToken(String token) {
        Integer id = tokenUtility.decodeToken(token);
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        if(addressBook.isEmpty())
        {
            log.warn("Unable to find address book details for given id: "+id);
            throw new AddresssBookException("Address Book Details not found");
        }
        else {
            addressBookRepository.deleteById(id);
            sender.sendEmail("kdesale1211@gmail.com", "Test Email", "Deleted SuccessFully, hii: "
                    +addressBook.get()+" Data deleted successfully plz check"
            );
        }
        throw new AddresssBookException("Deleted Token Successfully");
    }
 // getAll AddressBook list by token



    public List<AddressBook> getAddressBookDataByToken(String token)
    {
        int id=tokenUtility.decodeToken(token);
        Optional<AddressBook> isContactPresent=addressBookRepository.findById(id);
        if(isContactPresent.isPresent()) {
            List<AddressBook> listAddressBook=addressBookRepository.findAll();
            sender.sendEmail("kdesale1211@gmail.com", "Test Email", "Get your data with this token, hii: "
                    +isContactPresent.get().getEmail()+"Please Click here to get data-> "
                    +"http://localhost:8080/AddressBookApp/retrieve/"+token);
            return listAddressBook;
        }else {
            System.out.println("Exception ...Token not found!");
            throw new AddresssBookException("Exception Token Not found");

        }
    }



     //@param token is generated for all Address Book Data and it's unique for all contact.

    public AddressBook getRecordByToken(String token){
        Integer id = tokenUtility.decodeToken(token);
        Optional<AddressBook> newAddressBook = addressBookRepository.findById(id);
        if(newAddressBook.isEmpty()) {
            log.warn("Unable to find address book details for given id: "+id);
            throw new AddresssBookException("Address Book Details not found for that particular id");
        }
        else {
            sender.sendEmail("kdesale1211@gmail.com", "Test Email", "Get Data successfullt, hii: "
                    +newAddressBook.get().getEmail()+"Please Click here to get data-> "
                    +"http://localhost:8080/AddressBookApp/get/"+token);

            return newAddressBook.get();
        }

    }

}

