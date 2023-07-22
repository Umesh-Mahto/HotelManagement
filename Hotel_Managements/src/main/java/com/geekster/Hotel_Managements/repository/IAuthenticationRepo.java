package com.geekster.Hotel_Managements.repository;

import com.geekster.Hotel_Managements.model.Authentication;
import com.geekster.Hotel_Managements.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<Authentication,Long> {
    Authentication findByCustomer(Customer customer);

    Object findFirstByAuthenticationToken(String token);
}
