package com.sut.ood.onlinefoodbackend.Model.Customer.Repository;

import com.sut.ood.onlinefoodbackend.Model.Customer.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByRestaurantIDAndStatusOrderByDateCreatedDesc(Long restaurantID, String status);
    List<Order> findByCustomerIDOrderByDateCreatedDesc(Long customerID);
    List<Order> findByDeliveryIDAndStatusOrderByDateCreatedDesc(Long deliveryID, String status);
}
