package com.sut.ood.onlinefoodbackend.Model.DeliveryGuy;
import com.sut.ood.onlinefoodbackend.Model.Customer.Order;
import com.sut.ood.onlinefoodbackend.Model.User.User;
import com.sut.ood.onlinefoodbackend.Model.DeliveryGuy.DeliveryManagement;
import com.sut.ood.onlinefoodbackend.Model.User.UserDocument;
import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name = "DELIVERY")
@Entity
public class DeliveryGuy{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;
    @Column(name = "IS_ACTIVE")
    private boolean active;
    @Column(name = "RATING")
    private float overallRating;
    @Transient
    private Order assignedOrder; // bayad bbinam chejuri kelase order, in mitune y copy azash negah dare, ya y link behesh, ya y type e jadid shamele bazi data hash
    @Transient
    private LiveLocation currentLocation;
    @Transient
    private ArrayList<Order> orderHistory ;
    @Transient
    private User user;

    public DeliveryGuy() {
    }

    public DeliveryGuy(String firstName, String lastName, String middleName, Long restaurantId,
                       boolean active, float overallRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.restaurantId = restaurantId;
        this.active = active;
        this.overallRating = overallRating;
    }

    public DeliveryGuy(Long id, String firstName, String lastName, String middleName, Long restaurantId,
                       boolean active, float overallRating) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.restaurantId = restaurantId;
        this.active = active;
        this.overallRating = overallRating;
    }

    public DeliveryGuy(Long id, String firstName, String lastName, String middleName, Long restaurantId, boolean active, float overallRating, Order assignedOrder, LiveLocation currentLocation, ArrayList<Order> orderHistory, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.restaurantId = restaurantId;
        this.active = active;
        this.overallRating = overallRating;
        this.assignedOrder = assignedOrder;
        this.currentLocation = currentLocation;
        this.orderHistory = orderHistory;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public float getOverallRating() {
        return overallRating;
    }

    public LiveLocation getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(LiveLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public float getRating() {
        return overallRating;
    }
    public boolean isActive() {
        return active;
    }
    public LiveLocation getLocation(){return this.currentLocation;}
    public Order getAssignedOrder() {
        return assignedOrder;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public void setAssignedOrder(Order assingedOrder) {
        this.assignedOrder = assingedOrder;
    }
    public void setOverallRating(float rating) {
        this.overallRating = rating;
    }
    public void acceptDelivery(Order order) {
        this.assignedOrder = order;
    }

    public void viewOrderHistory() {
        return;
    }

    public boolean viewOrderInfo() {
        return true; // we should specify what info is
    }

    public Object orderDelivered() {
        return null;
    }




}