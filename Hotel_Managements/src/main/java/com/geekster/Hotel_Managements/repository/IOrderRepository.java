package com.geekster.Hotel_Managements.repository;

import com.geekster.Hotel_Managements.model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderFood,Long> {
}
