package com.sut.ood.onlinefoodbackend.Model.Customer;

import com.sut.ood.onlinefoodbackend.Model.User.User;
import jakarta.persistence.*;

@Table(name = "CUSTOMER")
@Entity
public class Customer {
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
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "USER_ID")
    private Long userID;

    @Transient
    private User user;


    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String middleName, String address, Long userID, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.userID = userID;
        this.user = user;
    }

    public Customer(Long id, String firstName, String lastName, String middleName, String address, Long userID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.userID = userID;
    }

    public Customer(String firstName, String lastName, String middleName, String address, Long userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.userID = userID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
