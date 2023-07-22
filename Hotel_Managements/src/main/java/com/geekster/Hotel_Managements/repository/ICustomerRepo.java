package com.geekster.Hotel_Managements.repository;

import com.geekster.Hotel_Managements.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Long> {

    Customer findFirstByCustomerEmail(String userEmail);


}
