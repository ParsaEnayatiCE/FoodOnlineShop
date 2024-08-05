package com.sut.ood.onlinefoodbackend.Model.Customer;

import com.sut.ood.onlinefoodbackend.Model.DeliveryGuy.DeliveryGuy;
import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Menu;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManagement implements ICustomerMethods{

    @Override
    public Response order(Order order) {
        return null;
    }

    @Override
    public Response reviewRestaurant(Customer customer, Review review, Restaurant restaurant, Order order) {
        return null;
    }

    @Override
    public Response reviewDelivery(Review review, DeliveryGuy delivery, Order order) {
        return null;
    }

    @Override
    public Review watchReview(Order order) {
        return null;
    }

    @Override
    public Response removeReviewRestaurant(Review review, Restaurant restaurant) {
        return null;
    }

    @Override
    public Response removeDelivery(Review review, DeliveryGuy delivery) {
        return null;
    }

    @Override
    public List<Order> getOrderHistory() {
        return List.of();
    }

    @Override
    public Order getCurrentOrder() {
        return null;
    }

    @Override
    public List<Menu> getRestaurantMenu(Restaurant restaurant) {
        return List.of();
    }

    @Override
    public List<Restaurant> searchForRestaurant(String searchText) {
        return List.of();
    }
}
