package com.geekster.Hotel_Managements.services;

import com.geekster.Hotel_Managements.model.Foods;
import com.geekster.Hotel_Managements.model.OrderFood;
import com.geekster.Hotel_Managements.model.Restaurant;
import com.geekster.Hotel_Managements.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    IOrderRepository iOrderRepository;
    @Autowired
    private IFoodRepository iFoodRepository;
    @Autowired
    private IRestaurantRepository iRestaurantRepository;

    @Autowired
    private IAuthenticationRepo authenticationRepo;
    @Autowired
    private ICustomerRepo customerRepo;
    public String addOrder(OrderFood orderFood) {
        Long foodId = orderFood.getFoods().getFoodsID();
        Long restaurantId = orderFood.getRestaurant().getRestaurantID();
        Foods foodsObj = iFoodRepository.findById(foodId).get();
        Restaurant restuarentObj = iRestaurantRepository.findById(restaurantId).get();

        orderFood.setFoods(foodsObj);
        orderFood.setRestaurant(restuarentObj);

        iOrderRepository.save(orderFood);

        return "Orderd Successfully!!";
    }

    public boolean check(String emailId, String token) {
        if (emailId == null || token == null) {
            throw new IllegalStateException("Wrong EmailId And Password!!");
        }
        try {
            String costumberEmail = customerRepo.findFirstByCustomerEmail(emailId).getCustmerEmail();
            //String authenticationToken = authenticationRepo.findFirstByAuthenticationToken(token).getAuthenticationToken();

            return costumberEmail.equals(emailId) ;
        }catch (Exception e){
            throw new IllegalStateException("Worong EmailId Or Password!!");
        }

    }


    public Iterable<OrderFood> getAllOrderdFood() {
        return iOrderRepository.findAll();
    }
}
