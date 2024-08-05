package com.sut.ood.onlinefoodbackend.Model.Customer.Repository;

import com.sut.ood.onlinefoodbackend.Model.Customer.Order;
import com.sut.ood.onlinefoodbackend.Model.Customer.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByOrderID(Long orderID);
}
