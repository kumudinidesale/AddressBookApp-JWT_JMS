package com.example.addressbookapp1.repository;

import com.example.addressbookapp1.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
