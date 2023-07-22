package com.geekster.Hotel_Managements.services;

import com.geekster.Hotel_Managements.model.Foods;
import com.geekster.Hotel_Managements.repository.IFoodRepository;
import com.geekster.Hotel_Managements.repository.IRestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    private IFoodRepository iFoodRepository;
    @Autowired
    private IRestaurantRepository iRestaurant;

    public String addFood(Foods food) {
//        Long restaurantId =  food.getFoodsID();
//
//        Restaurant restaurantObj = iRestaurant.findById(restaurantId).get();
//        food.setRestaurant(restaurantObj);
        iFoodRepository.save(food);
        return "Food added Successfully!!";
    }

    public String deleteFood(Long id) {
        iFoodRepository.deleteById(id);
        return "Food deleted Successfully!!";
    }
    @Transactional
    public String updateFoodById(Long id, Double price) {
        iFoodRepository.updateFoodById(id , price);
        return "Food updated Succesfully!!";
    }
}
