package com.geekster.Hotel_Managements.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantID;
    private String restaurantName;
    private String restaurantAddress;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "restaurant")
    private List<Foods> foods;

}
