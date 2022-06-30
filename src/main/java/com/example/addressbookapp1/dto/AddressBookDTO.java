package com.example.addressbookapp1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Data
@AllArgsConstructor
public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee firstName is Invalid")
    private String fullName;

    @NotEmpty(message = "address not  null")
    private String address;
    @NotEmpty(message = "phoneNumber not  null")
    private String phoneNumber;
    @NotEmpty(message = "city not  null")
    private String city;
    @NotEmpty(message = "state not  null")
    private String state;
    @NotNull(message = "zip not  null")
    private int zip;
}
