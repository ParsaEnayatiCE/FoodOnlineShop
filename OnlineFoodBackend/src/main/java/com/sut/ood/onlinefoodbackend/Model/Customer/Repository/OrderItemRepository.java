package com.sut.ood.onlinefoodbackend.Model.Customer.Repository;

import com.sut.ood.onlinefoodbackend.Model.Customer.Order;
import com.sut.ood.onlinefoodbackend.Model.Customer.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderID(Long orderId);
}
