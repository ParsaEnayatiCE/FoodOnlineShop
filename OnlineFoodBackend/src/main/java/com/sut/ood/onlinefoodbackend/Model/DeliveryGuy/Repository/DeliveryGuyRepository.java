package com.sut.ood.onlinefoodbackend.Model.DeliveryGuy.Repository;

import com.sut.ood.onlinefoodbackend.Model.Customer.Order;
import com.sut.ood.onlinefoodbackend.Model.DeliveryGuy.DeliveryGuy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryGuyRepository extends JpaRepository<DeliveryGuy, Long> {
    List<DeliveryGuy> findByRestaurantId(long restaurantId);
    List<DeliveryGuy> findByRestaurantIdAndActive(long restaurantId, boolean active);
}
