package com.geekster.Hotel_Managements.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authenticationId;
    private String authenticationToken;
    private LocalDate localDate;
    @OneToOne
    @JoinColumn(nullable = false,name = "fk_customer")
    private Customer customer;

    public Authentication(Customer customer) {
        this.customer = customer;
        this.localDate=LocalDate.now();
        this.authenticationToken= UUID.randomUUID().toString();
    }
}
