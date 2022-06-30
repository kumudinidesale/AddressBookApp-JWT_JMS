package com.example.addressbookapp1.repository;

import com.example.addressbookapp1.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {



    @Query(value = "SELECT * from address_book_table ORDER BY city DESC", nativeQuery = true)
    List<AddressBook> sortCityDescOder();

    @Query(value = "SELECT * from address_book_table ORDER BY city ", nativeQuery = true)
    List<AddressBook> sortCityAscOder();

}
