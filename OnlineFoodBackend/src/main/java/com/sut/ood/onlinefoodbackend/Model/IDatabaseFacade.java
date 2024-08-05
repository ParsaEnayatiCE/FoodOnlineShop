package com.sut.ood.onlinefoodbackend.Model;

import com.sut.ood.onlinefoodbackend.Model.Customer.Customer;
import com.sut.ood.onlinefoodbackend.Model.Customer.Order;
import com.sut.ood.onlinefoodbackend.Model.Customer.OrderItem;
import com.sut.ood.onlinefoodbackend.Model.Customer.Review;
import com.sut.ood.onlinefoodbackend.Model.DeliveryGuy.DeliveryGuy;
import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Menu;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.MenuItem;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Restaurant;
import com.sut.ood.onlinefoodbackend.Model.User.User;

import java.util.List;

public interface IDatabaseFacade {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findUserByPhone(String phone);
    Response addUser(User user);
    Response removeUser(User user);
    User CheckJwtCredentials(String username, String password, String email);
    User findUserByID(Long id);

    Customer findCustomerByUserId(Long userId);
    Response addCustomer(Customer customer);
    Response removeCustomer(Customer customer);

    List<Restaurant> findRestaurantByName(String fullName);
    Restaurant findRestaurantByUserID(Long userID);
    Response addRestaurant(Restaurant restaurant);
    Response removeRestaurant(Restaurant restaurant);

    List<Menu> findMenuByRestaurantID(Long restaurantID);
    Response addMenu(Menu menu);
    Response removeMenu(Menu menu);
    MenuItem findMenuItemByID(Long ID);
    Response addMenuItem(MenuItem menuItem);
    Response removeMenuItem(MenuItem menuItem);

    List<DeliveryGuy> findDeliveryByRestaurantID(Long ID);
    List<DeliveryGuy> findDeliveryByRestaurantIdAndActive(Long ID, boolean active);
    Response addDelivery(DeliveryGuy delivery);
    Response removeDelivery(DeliveryGuy delivery);

    List<OrderItem> findOrderItemByOrderId(Long orderId);
    Response addOrderItem(OrderItem orderItem);
    Response removeOrderItem(OrderItem orderItem);
    List<Order> findOrderByRestaurantIDAndStatus(Long restaurantID, String status);
    List<Order> findOrderByCustomerID(Long customerID);
    List<Order> findOrderByDeliveryIDAndStatus(Long deliveryID, String status);
    Response addOrder(Order order);
    Response removeOrder(Order order);

    Review findReviewByOrderID(Long orderID);
    Response addReview(Review review);
    Response removeReview(Review review);




}
