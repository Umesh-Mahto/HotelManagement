package com.geekster.Hotel_Managements.services;

import com.geekster.Hotel_Managements.model.Foods;
import com.geekster.Hotel_Managements.model.Restaurant;
import com.geekster.Hotel_Managements.repository.IFoodRepository;
import com.geekster.Hotel_Managements.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantService {
    @Autowired
    private IRestaurantRepository iRestaurantRepository;

    @Autowired
    private IFoodRepository iFood;

    public String addRestaurant(Restaurant restaurant) {


        List<Foods> foodList =restaurant.getFoods();
        for(Foods foodObj : foodList){
            foodObj.setRestaurant(restaurant);
        }
        iRestaurantRepository.save(restaurant);
        return "Restuarent added Successfully!!";
    }

    public Iterable<Restaurant> getAllRestaurant() {
        return iRestaurantRepository.findAll();
    }
}
