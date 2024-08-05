package com.sut.ood.onlinefoodbackend.Model.Customer;

import com.sut.ood.onlinefoodbackend.Model.DeliveryGuy.DeliveryGuy;
import com.sut.ood.onlinefoodbackend.Model.Enum.OrderStatus;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.MenuItem;
import com.sut.ood.onlinefoodbackend.Model.Restaurant.Restaurant;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name = "ORDERS")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DESTINATION_ADDRESS")
    private String destinationAddress;
    @Column(name = "DATE_CREATED")
    private Date dateCreated;
    @Column(name = "RESTAURANT_ID")
    private Long restaurantID;
    @Column(name = "CUSTOMER_ID")
    private Long customerID;
    @Column(name = "REVIEW_ID")
    private Long reviewID;
    @Column(name = "DELIVERY_ID")
    private Long deliveryID;


    @Transient
    private Customer customer;
    @Transient
    private Restaurant restaurant;
    @Transient
    private List<OrderItem> menuItemList;
    @Transient
    private Review review;
    @Transient
    private DeliveryGuy deliveryGuy;

    public Order() {
    }

    public Order(Long ID, String status, String destinationAddress, Date dateCreated, Long restaurantID, Long customerID, Long reviewID, Long deliveryID) {
        this.ID = ID;
        this.status = status;
        this.destinationAddress = destinationAddress;
        this.dateCreated = dateCreated;
        this.restaurantID = restaurantID;
        this.customerID = customerID;
        this.reviewID = reviewID;
        this.deliveryID = deliveryID;
    }

    public Order(String status, String destinationAddress, Date dateCreated, Long restaurantID,
                 Long customerID, Long reviewID, Long deliveryID) {
        this.status = status;
        this.destinationAddress = destinationAddress;
        this.dateCreated = dateCreated;
        this.restaurantID = restaurantID;
        this.customerID = customerID;
        this.reviewID = reviewID;
        this.deliveryID = deliveryID;
    }

    public Order(Long ID, String status, String destinationAddress, Date dateCreated, Long restaurantID,
                 Long customerID, Long reviewID, Long deliveryID, Customer customer, Restaurant restaurant,
                 List<OrderItem> menuItemList, Review review, DeliveryGuy deliveryGuy) {
        this.ID = ID;
        this.status = status;
        this.destinationAddress = destinationAddress;
        this.dateCreated = dateCreated;
        this.restaurantID = restaurantID;
        this.customerID = customerID;
        this.reviewID = reviewID;
        this.deliveryID = deliveryID;
        this.customer = customer;
        this.restaurant = restaurant;
        this.menuItemList = menuItemList;
        this.review = review;
        this.deliveryGuy = deliveryGuy;
    }

    public Long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Long restaurantID) {
        this.restaurantID = restaurantID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public Long getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(Long deliveryID) {
        this.deliveryID = deliveryID;
    }

    public DeliveryGuy getDeliveryGuy() {
        return deliveryGuy;
    }

    public void setDeliveryGuy(DeliveryGuy deliveryGuy) {
        this.deliveryGuy = deliveryGuy;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<OrderItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setID(Long id) {
        this.ID = id;
    }

    public Long getID() {
        return ID;
    }
}
