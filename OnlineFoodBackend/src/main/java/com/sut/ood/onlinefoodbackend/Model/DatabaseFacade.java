package com.sut.ood.onlinefoodbackend.Model;

import com.sut.ood.onlinefoodbackend.Model.Customer.Customer;
import com.sut.ood.onlinefoodbackend.Model.Customer.Order;
import com.sut.ood.onlinefoodbackend.Model.Customer.OrderItem;
import com.sut.ood.onlinefoodbackend.Model.Customer.Repository.CustomerRepository;
import com.sut.ood.onlinefoodbackend.Model.Customer.Repository.OrderItemRepository;
import com.sut.ood.onlinefoodbackend.Model.Customer.Repository.OrderRepository;
import com.sut.ood.onlinefoodbackend.Model.Customer.Repository.ReviewRepository;
import com.sut.ood.onlinefoodbackend.Model.Customer.Review;
import com.sut.ood.onlinefoodbackend.Model.DeliveryGuy.DeliveryGuy;
import com.sut.ood.onlinefoodbackend.Model.DeliveryGuy.Repository.DeliveryGuyRepository;
import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Menu;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.MenuItem;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Repository.MenuItemRepository;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Repository.MenuRepository;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Repository.RestaurantRepository;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Restaurant;
import com.sut.ood.onlinefoodbackend.Model.User.Repository.UserRepository;
import com.sut.ood.onlinefoodbackend.Model.User.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sut.ood.onlinefoodbackend.Model.Enum.Response.*;

@Service
public class DatabaseFacade implements IDatabaseFacade{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DeliveryGuyRepository deliveryGuyRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @Override
    public User findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElse(null);
    }

    @Override
    public User findUserByPhone(String phone) {
        Optional<User> user = userRepository.findByPhoneNumber(phone);
        return user.orElse(null);
    }

    @Override
    public Response addUser(User user) {
        try {
            userRepository.save(user);
            return USER_SAVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return USER_NOT_SAVED_SUCCESSFULLY;
        }
    }

    @Override
    public Response removeUser(User user) {
        try {
            userRepository.delete(user);
            return USER_REMOVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return USER_NOT_REMOVED_SUCCESSFULLY;
        }
    }

    @Override
    public User CheckJwtCredentials(String username, String password, String email) {
        Optional<User> user = userRepository.findByUsernameAndPasswordAndEmail(username, password, email);
        return user.orElse(null);
    }

    @Override
    public User findUserByID(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public Customer findCustomerByUserId(Long userId) {
        Optional<Customer> customer = customerRepository.findByUserID(userId);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }

    @Override
    public Response addCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
            return CUSTOMER_SAVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return CUSTOMER_NOT_SAVED_SUCCESSFULLY;
        }
    }

    @Override
    public Response removeCustomer(Customer customer) {
        try {
            customerRepository.delete(customer);
            return CUSTOMER_REMOVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return CUSTOMER_NOT_REMOVED_SUCCESSFULLY;
        }
    }

    @Override
    public List<Restaurant> findRestaurantByName(String fullName) {
        return restaurantRepository.findByName(fullName);
    }

    @Override
    public Restaurant findRestaurantByUserID(Long userID) {
        Optional<Restaurant> restaurant = restaurantRepository.findByUserID(userID);
        if (restaurant.isPresent()) {
            return restaurant.get();
        } else {
            return null;
        }
    }

    @Override
    public Response addRestaurant(Restaurant restaurant) {
        try {
            restaurantRepository.save(restaurant);
            return RESTAURANT_SAVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return RESTAURANT_NOT_SAVED_SUCCESSFULLY;
        }
    }

    @Override
    public Response removeRestaurant(Restaurant restaurant) {
        try {
            restaurantRepository.delete(restaurant);
            return RESTAURANT_REMOVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return RESTAURANT_NOT_REMOVED_SUCCESSFULLY;
        }
    }

    @Override
    public List<Menu> findMenuByRestaurantID(Long restaurantID) {
        return menuRepository.findByRestaurantID(restaurantID);
    }

    @Override
    public Response addMenu(Menu menu) {
        try {
            menuRepository.save(menu);
            return MENU_SAVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return MENU_NOT_SAVED_SUCCESSFULLY;
        }
    }

    @Override
    public Response removeMenu(Menu menu) {
        try {
            menuRepository.delete(menu);
            return MENU_REMOVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return MENU_NOT_REMOVED_SUCCESSFULLY;
        }
    }

    @Override
    public MenuItem findMenuItemByID(Long ID) {
        Optional<MenuItem> menuItem = menuItemRepository.findById(ID);
        if (menuItem.isPresent()) {
            return menuItem.get();
        } else {
            return null;
        }
    }

    @Override
    public Response addMenuItem(MenuItem menuItem) {
        try {
            menuItemRepository.save(menuItem);
            return MENU_ITEM_SAVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return MENU_ITEM_NOT_SAVED_SUCCESSFULLY;
        }
    }

    @Override
    public Response removeMenuItem(MenuItem menuItem) {
        try {
            menuItemRepository.delete(menuItem);
            return MENU_ITEM_REMOVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return MENU_ITEM_NOT_REMOVED_SUCCESSFULLY;
        }
    }

    @Override
    public List<DeliveryGuy> findDeliveryByRestaurantID(Long ID) {
        return deliveryGuyRepository.findByRestaurantId(ID);
    }

    @Override
    public List<DeliveryGuy> findDeliveryByRestaurantIdAndActive(Long ID, boolean active) {
        return deliveryGuyRepository.findByRestaurantIdAndActive(ID, active);
    }

    @Override
    public Response addDelivery(DeliveryGuy delivery) {
        try {
            deliveryGuyRepository.save(delivery);
            return DELIVERY_SAVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return DELIVERY_NOT_SAVED_SUCCESSFULLY;
        }
    }

    @Override
    public Response removeDelivery(DeliveryGuy delivery) {
        try {
            deliveryGuyRepository.delete(delivery);
            return DELIVERY_REMOVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return DELIVERY_NOT_REMOVED_SUCCESSFULLY;
        }
    }

    @Override
    public List<OrderItem> findOrderItemByOrderId(Long orderId) {
        return orderItemRepository.findByOrderID(orderId);
    }

    @Override
    public Response addOrderItem(OrderItem orderItem) {
        try {
            orderItemRepository.save(orderItem);
            return ORDER_ITEM_SAVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return ORDER_ITEM_NOT_SAVED_SUCCESSFULLY;
        }
    }

    @Override
    public Response removeOrderItem(OrderItem orderItem) {
        try {
            orderItemRepository.delete(orderItem);
            return ORDER_ITEM_REMOVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return ORDER_ITEM_NOT_REMOVED_SUCCESSFULLY;
        }
    }

    @Override
    public List<Order> findOrderByRestaurantIDAndStatus(Long restaurantID, String status) {
        return orderRepository.findByRestaurantIDAndStatusOrderByDateCreatedDesc(restaurantID, status);
    }

    @Override
    public List<Order> findOrderByCustomerID(Long customerID) {
        return orderRepository.findByCustomerIDOrderByDateCreatedDesc(customerID);
    }

    @Override
    public List<Order> findOrderByDeliveryIDAndStatus(Long deliveryID, String status) {
        return orderRepository.findByDeliveryIDAndStatusOrderByDateCreatedDesc(deliveryID, status);
    }

    @Override
    public Response addOrder(Order order) {
        try {
            orderRepository.save(order);
            return ORDER_SAVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return ORDER_NOT_SAVED_SUCCESSFULLY;
        }
    }

    @Override
    public Response removeOrder(Order order) {
        try {
            orderRepository.delete(order);
            return ORDER_REMOVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return ORDER_NOT_REMOVED_SUCCESSFULLY;
        }
    }

    @Override
    public Review findReviewByOrderID(Long orderID) {
        Optional<Review> review = reviewRepository.findByOrderID(orderID);
        if (review.isPresent()) {
            return review.get();
        } else {
            return null;
        }
    }

    @Override
    public Response addReview(Review review) {
        try {
            reviewRepository.save(review);
            return REVIEW_SAVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return REVIEW_NOT_SAVED_SUCCESSFULLY;
        }
    }

    @Override
    public Response removeReview(Review review) {
        try {
            reviewRepository.delete(review);
            return REVIEW_REMOVED_SUCCESSFULLY;
        } catch (Exception e) {
            e.printStackTrace();
            return REVIEW_NOT_REMOVED_SUCCESSFULLY;
        }
    }


}
