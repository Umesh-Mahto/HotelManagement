package com.geekster.Hotel_Managements.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Foods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodsID;
    private String foodsName;
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    Restaurant restaurant;
}
