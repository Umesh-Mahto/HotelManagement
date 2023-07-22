package com.geekster.Hotel_Managements.repository;

import com.geekster.Hotel_Managements.model.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository extends JpaRepository<Foods, Long> {
    @Modifying
    @Query(value = "update foods set price = :price where foodsid = :id" , nativeQuery = true)
    void updateFoodById(Long id, Double price);
}
