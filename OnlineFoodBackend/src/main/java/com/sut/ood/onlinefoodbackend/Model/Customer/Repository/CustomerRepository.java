package com.sut.ood.onlinefoodbackend.Model.Customer.Repository;

import com.sut.ood.onlinefoodbackend.Model.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUserID(long userID);
}
