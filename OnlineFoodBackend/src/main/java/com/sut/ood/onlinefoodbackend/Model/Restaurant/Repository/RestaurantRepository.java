package com.sut.ood.onlinefoodbackend.Model.Restaurant.Repository;

import com.sut.ood.onlinefoodbackend.Model.Customer.Order;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByName(String restaurantName);
    Optional<Restaurant> findByUserID(Long userID);
}
