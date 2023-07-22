package com.geekster.Hotel_Managements.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CustomerId;
    private String customerEmail;
    private String CustomerPassword;
    private  String CustomerFirstName;
    private String CustomerLastName;
    private String CustomerAddress;
    private  String CustomerContact;

    public Customer(String customerEmail, String customerPassword, String customerFirstName, String customerLastName, String customerAddress, String customerContact) {
        this.customerEmail = customerEmail;
        CustomerPassword = customerPassword;
        CustomerFirstName = customerFirstName;
        CustomerLastName = customerLastName;
        CustomerAddress = customerAddress;
        CustomerContact = customerContact;
    }


    public String getCustmerEmail() {
        return "a";
    }
}
