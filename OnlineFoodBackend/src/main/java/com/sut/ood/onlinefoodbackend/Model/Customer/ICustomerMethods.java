package com.sut.ood.onlinefoodbackend.Model.Customer;

import com.sut.ood.onlinefoodbackend.Model.DeliveryGuy.DeliveryGuy;
import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Menu;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Restaurant;

import java.util.List;

public interface ICustomerMethods {
    Response order(Order order);
    Response reviewRestaurant(Customer customer, Review review, Restaurant restaurant, Order order);
    Response reviewDelivery(Review review, DeliveryGuy delivery, Order order);
    Review watchReview(Order order);
    Response removeReviewRestaurant(Review review, Restaurant restaurant);
    Response removeDelivery(Review review, DeliveryGuy delivery);
    List<Order> getOrderHistory();
    Order getCurrentOrder();
    List<Menu> getRestaurantMenu(Restaurant restaurant);
    List<Restaurant> searchForRestaurant(String searchText);
    //OrderTrack watchOrderTrack(Order order);


}
